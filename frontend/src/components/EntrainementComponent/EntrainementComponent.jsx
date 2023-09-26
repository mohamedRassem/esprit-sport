import React, { Component } from 'react';
import axios from 'axios';

class EntrainementComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrainements: [],
      sets: 0,
      repetitions: 0,
      isEditing: false,
      selectedEntrainementId: null,
    };
  }

  componentDidMount() {
    this.loadEntrainements();
  }

  loadEntrainements = () => {
    axios
      .get('http://localhost:8081/exam/entrainement/get-Entrainements')
      .then((response) => {
        this.setState({ entrainements: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des entrainements :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (entrainementId) => {
    const selectedEntrainement = this.state.entrainements.find(
      (entrainement) => entrainement.id === entrainementId
    );
    if (selectedEntrainement) {
      this.setState({
        isEditing: true,
        selectedEntrainementId: entrainementId,
        sets: selectedEntrainement.sets,
        repetitions: selectedEntrainement.repetitions,
      });
    }
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedEntrainementId: null,
      sets: 0,
      repetitions: 0,
    });
  };

  handleDeleteClick = (entrainementId) => {
    axios
      .delete(`http://localhost:8081/exam/entrainement/delete-Entrainement/${entrainementId}`)
      .then((response) => {
        console.log('Entrainement supprimé avec succès :', response.data);
        this.loadEntrainements();
        this.handleCancelEdit();
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression de l\'entrainement :', error);
      });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const entrainementData = {
      sets: this.state.sets,
      repetitions: this.state.repetitions,
    };

    if (this.state.isEditing) {
      axios
        .put(
          `http://localhost:8081/exam/entrainement/update-Entrainement/${this.state.selectedEntrainementId}`,
          entrainementData
        )
        .then((response) => {
          console.log('Entrainement mis à jour avec succès :', response.data);
          this.loadEntrainements();
          this.handleCancelEdit();
        })
        .catch((error) => {
          console.error('Erreur lors de la mise à jour de l\'entrainement :', error);
        });
    } else {
      axios
        .post('http://localhost:8081/exam/entrainement/add-Entrainement', entrainementData)
        .then((response) => {
          console.log('Entrainement ajouté avec succès :', response.data);
          this.loadEntrainements();
          this.setState({
            sets: 0,
            repetitions: 0,
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout de l\'entrainement :', error);
        });
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'orange' }}>Gestion des Entrainements</h1>

        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Sets :</label>
            <input
              type="number"
              name="sets"
              value={this.state.sets}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <label>Répétitions :</label>
            <input
              type="number"
              name="repetitions"
              value={this.state.repetitions}
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
          {this.state.entrainements.map((entrainement) => (
            <li key={entrainement.id}>
              <strong>Sets :</strong> {entrainement.sets} <br />
              <strong>Répétitions :</strong> {entrainement.repetitions} <br />
              <button
                type="button"
                onClick={() => this.handleEditClick(entrainement.id)}
              >
                Modifier
              </button>
              <button
                type="button"
                onClick={() => this.handleDeleteClick(entrainement.id)}
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

export default EntrainementComponent;
