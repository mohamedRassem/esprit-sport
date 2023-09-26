import React, { Component } from 'react';
import axios from 'axios';

class ExerciceComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      exercices: [],
      nom: '',
      description: '',
      isEditing: false,
      selectedExercice: null,
    };
  }

  componentDidMount() {
    this.loadExercices();
  }

  loadExercices = () => {
    axios
      .get('http://localhost:8081/exam/exercice/get-Exercices')
      .then((response) => {
        this.setState({ exercices: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des exercices :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (exercice) => {
    this.setState({
      isEditing: true,
      selectedExercice: exercice,
      nom: exercice.nom,
      description: exercice.description,
    });
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedExercice: null,
      nom: '',
      description: '',
    });
  };

  handleDeleteClick = (exercice) => {
    axios
      .delete(`http://localhost:8081/exam/exercice/supprimer/${exercice.nom}`)
      .then((response) => {
        console.log('Exercice supprimé avec succès :', response.data);
        this.loadExercices();
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression de l\'exercice :', error);
      });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const exerciceData = {
      nom: this.state.nom,
      description: this.state.description,
    };

    if (this.state.isEditing) {
      axios
        .put(
          `http://localhost:8081/exam/exercice/modifier/${this.state.selectedExercice.nom}`,
          exerciceData
        )
        .then((response) => {
          console.log('Exercice mis à jour avec succès :', response.data);
          this.loadExercices();
          this.handleCancelEdit();
        })
        .catch((error) => {
          console.error('Erreur lors de la mise à jour de l\'exercice :', error);
        });
    } else {
      axios
        .post('http://localhost:8081/exam/exercice/ajouter', exerciceData)
        .then((response) => {
          console.log('Exercice ajouté avec succès :', response.data);
          this.loadExercices();
          this.setState({
            nom: '',
            description: '',
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout de l\'exercice :', error);
        });
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'orange' }}>Gestion des Exercices</h1>
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
            <label>Description :</label>
            <input
              type="text"
              name="description"
              value={this.state.description}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <button type="submit">{this.state.isEditing ? 'Modifier' : 'Ajouter'}</button>
            {this.state.isEditing && (
              <button type="button" onClick={this.handleCancelEdit}>Annuler</button>
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
          {this.state.exercices.map((exercice) => (
            <li key={exercice.nom}>
              <strong>Nom :</strong> {exercice.nom} <br />
              <strong>Description :</strong> {exercice.description} <br />
              <button type="button" onClick={() => this.handleEditClick(exercice)}>Modifier</button>
              <button type="button" onClick={() => this.handleDeleteClick(exercice)}>Supprimer</button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default ExerciceComponent;







