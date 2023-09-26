import React, { Component } from 'react';
import axios from 'axios';

class JourEntrainementComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      joursEntrainement: [],
      date: '',
      isEditing: false,
      selectedJourEntrainementId: null,
    };
  }

  componentDidMount() {
    this.loadJoursEntrainement();
  }

  loadJoursEntrainement = () => {
    axios
      .get('http://localhost:8081/exam/jourentrainement/get-JoursEntrainement')
      .then((response) => {
        this.setState({ joursEntrainement: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des jours d\'entrainement :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (jourEntrainementId) => {
    const selectedJourEntrainement = this.state.joursEntrainement.find(
      (jourEntrainement) => jourEntrainement.id === jourEntrainementId
    );
    if (selectedJourEntrainement) {
      this.setState({
        isEditing: true,
        selectedJourEntrainementId: jourEntrainementId,
        date: selectedJourEntrainement.date,
      });
    }
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedJourEntrainementId: null,
      date: '',
    });
  };

  handleDeleteClick = (jourEntrainementId) => {
    axios
      .delete(`http://localhost:8081/exam/jourentrainement/delete-JourEntrainement/${jourEntrainementId}`)
      .then((response) => {
        console.log('Jour d\'entrainement supprimé avec succès :', response.data);
        this.loadJoursEntrainement();
        this.handleCancelEdit();
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression du jour d\'entrainement :', error);
      });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const jourEntrainementData = {
      date: this.state.date,
    };

    if (this.state.isEditing) {
      axios
        .put(
          `http://localhost:8081/exam/jourentrainement/update-JourEntrainement/${this.state.selectedJourEntrainementId}`,
          jourEntrainementData
        )
        .then((response) => {
          console.log('Jour d\'entrainement mis à jour avec succès :', response.data);
          this.loadJoursEntrainement();
          this.handleCancelEdit();
        })
        .catch((error) => {
          console.error('Erreur lors de la mise à jour du jour d\'entrainement :', error);
        });
    } else {
      axios
        .post('http://localhost:8081/exam/jourentrainement/add-JourEntrainement', jourEntrainementData)
        .then((response) => {
          console.log('Jour d\'entrainement ajouté avec succès :', response.data);
          this.loadJoursEntrainement();
          this.setState({
            date: '',
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout du jour d\'entrainement :', error);
        });
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'orange' }}>Gestion des Jours d'Entrainement</h1>

        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Date :</label>
            <input
              type="date"
              name="date"
              value={this.state.date}
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
          {this.state.joursEntrainement.map((jourEntrainement) => (
            <li key={jourEntrainement.id}>
              <strong>Date :</strong> {jourEntrainement.date} <br />
              <button
                type="button"
                onClick={() => this.handleEditClick(jourEntrainement.id)}
              >
                Modifier
              </button>
              <button
                type="button"
                onClick={() => this.handleDeleteClick(jourEntrainement.id)}
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

export default JourEntrainementComponent;
