import React, { Component } from 'react';
import axios from 'axios';

class SportComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      sports: [],
      nom: '',
      categorieId: '', // L'ID de la catégorie sportive associée
      isEditing: false,
      selectedSportId: null,
    };
  }

  componentDidMount() {
    this.loadSports();
  }

  loadSports = () => {
    axios
      .get('http://localhost:8081/exam/sport/get-Sports')
      .then((response) => {
        this.setState({ sports: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des sports :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (sportId) => {
    const selectedSport = this.state.sports.find(
      (sport) => sport.id === sportId
    );
    if (selectedSport) {
      this.setState({
        isEditing: true,
        selectedSportId: sportId,
        nom: selectedSport.nom,
        categorieId: selectedSport.categorieId,
      });
    }
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedSportId: null,
      nom: '',
      categorieId: '',
    });
  };

  handleDeleteClick = (sportId) => {
    axios
      .delete(`http://localhost:8081/exam/sport/delete-Sport/${sportId}`)
      .then((response) => {
        console.log('Sport supprimé avec succès :', response.data);
        this.loadSports();
        this.handleCancelEdit();
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression du sport :', error);
      });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const sportData = {
      nom: this.state.nom,
      categorieId: this.state.categorieId,
    };

    if (this.state.isEditing) {
      axios
        .put(
          `http://localhost:8081/exam/sport/update-Sport/${this.state.selectedSportId}`,
          sportData
        )
        .then((response) => {
          console.log('Sport mis à jour avec succès :', response.data);
          this.loadSports();
          this.handleCancelEdit();
        })
        .catch((error) => {
          console.error('Erreur lors de la mise à jour du sport :', error);
        });
    } else {
      axios
        .post('http://localhost:8081/exam/sport/add-Sport', sportData)
        .then((response) => {
          console.log('Sport ajouté avec succès :', response.data);
          this.loadSports();
          this.setState({
            nom: '',
            categorieId: '',
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout du sport :', error);
        });
    }
  };

  render() {
    return (
      <div>
       <h1 style={{ color: 'orange' }}>Gestion des Sports</h1>

        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Nom :</label>
            <input
              type="text"
              name="nom"
              value={this.state.nom}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <label>Catégorie ID :</label>
            <input
              type="text"
              name="categorieId"
              value={this.state.categorieId}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <button type="submit">
              {this.state.isEditing ? 'Modifier' : 'Ajouter'}
            </button>
            {this.state.isEditing && (
              <button type="button" onClick={this.handleCancelEdit}>
                Annuler
              </button>
              
            )}
             <button type="button" onClick={this.handleDeleteClick}>
  Supprimer
</button>
<button type="button" onClick={this.handleDeleteClick}>
  modifier
</button>
<button type="button" onClick={this.handleDeleteClick}>
  afficher
</button>
          </div>
        </form>

        <ul>
          {this.state.sports.map((sport) => (
            <li key={sport.id}>
              <strong>Nom :</strong> {sport.nom} <br />
              <strong>Catégorie ID :</strong> {sport.categorieId} <br />
              <button
                type="button"
                onClick={() => this.handleEditClick(sport.id)}
              >
                Modifier
              </button>
              <button
                type="button"
                onClick={() => this.handleDeleteClick(sport.id)}
              >
                Supprimer
              </button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default SportComponent;
