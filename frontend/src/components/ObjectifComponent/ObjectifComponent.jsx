import React, { Component } from 'react';
import axios from 'axios';
import './ObjectifComponent.css'; // Importez votre fichier CSS

class ObjectifComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      objectifs: [], // Stocker la liste des objectifs
      description: '',
      dateDebut: '',
      dateFin: '',
      selectedObjectId: null,
      isEditing: false,
    };
  }

  componentDidMount() {
    // Chargez la liste des objectifs au montage du composant
    this.loadObjectifs();
  }

  loadObjectifs = () => {
    // Chargez la liste des objectifs depuis l'API
    axios.get('http://localhost:8081/exam/objectif/get-Objectifs')
      .then(response => {
        this.setState({ objectifs: response.data });
      })
      .catch(error => {
        console.error('Erreur lors du chargement des objectifs:', error);
      });
  }

  handleInputChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleEditClick = (objectId) => {
    // Mettez à jour l'état pour activer le mode édition
    const selectedObjectif = this.state.objectifs.find(objectif => objectif.id === objectId);
    if (selectedObjectif) {
      this.setState({
        isEditing: true,
        selectedObjectId: objectId,
        description: selectedObjectif.description,
        dateDebut: selectedObjectif.dateDebut,
        dateFin: selectedObjectif.dateFin,
      });
    }
  }

  handleCancelEdit = () => {
    // Réinitialisez le formulaire d'édition
    this.setState({
      isEditing: false,
      selectedObjectId: null,
      description: '',
      dateDebut: '',
      dateFin: '',
    });
  }

  handleDeleteClick = () => {
    // Envoyez une requête de suppression à l'API avec l'ID sélectionné
    const objectIdToDelete = this.state.selectedObjectId;
    if (objectIdToDelete) {
      axios.delete(`http://localhost:8081/exam/objectif/delete-Objectif/${objectIdToDelete}`)
        .then(response => {
          console.log('Objectif supprimé avec succès:', response.data);
          // Rechargez la liste des objectifs après la suppression
          this.loadObjectifs();
          // Réinitialisez le formulaire d'édition
          this.handleCancelEdit();
        })
        .catch(error => {
          console.error('Erreur lors de la suppression de l\'objectif:', error);
        });
    }
  }

  handleSubmit = event => {
    event.preventDefault();

    // Construisez l'objet objectif à envoyer
    const objectifData = {
      description: this.state.description,
      dateDebut: this.state.dateDebut,
      dateFin: this.state.dateFin,
    };

    if (this.state.isEditing) {
      // Si nous sommes en mode édition, effectuez une mise à jour
      axios.put(`http://localhost:8081/exam/objectif/update-Objectif/${this.state.selectedObjectId}`, objectifData)
        .then(response => {
          console.log('Objectif mis à jour avec succès:', response.data);
          // Rechargez la liste des objectifs après la mise à jour
          this.loadObjectifs();
          // Réinitialisez le formulaire d'édition
          this.handleCancelEdit();
        })
        .catch(error => {
          console.error('Erreur lors de la mise à jour de l\'objectif:', error);
        });
    } else {
      // Sinon, effectuez une création
      axios.post('http://localhost:8081/exam/objectif/add-Objectif', objectifData)
        .then(response => {
          console.log('Objectif ajouté avec succès:', response.data);
          // Rechargez la liste des objectifs après l'ajout
          this.loadObjectifs();
          // Réinitialisez le formulaire d'ajout
          this.setState({
            description: '',
            dateDebut: '',
            dateFin: '',
          });
        })
        .catch(error => {
          console.error('Erreur lors de l\'ajout de l\'objectif:', error);
        });
    }
  }

  render() {
    return (
      <div>
        <h1>Gestion des Objectifs</h1>

        {/* Formulaire d'ajout/modification d'objectif */}
        <form onSubmit={this.handleSubmit}>
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
            <label>Date de début :</label>
            <input
              type="text" // Utilisez le type approprié pour la date
              name="dateDebut"
              value={this.state.dateDebut}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <label>Date de fin :</label>
            <input
              type="text" // Utilisez le type approprié pour la date
              name="dateFin"
              value={this.state.dateFin}
              onChange={this.handleInputChange}
            />
          </div>
          {/* Boutons d'action */}
          <div>
            <button type="submit">{this.state.isEditing ? 'Modifier' : 'Ajouter'}</button>
            {this.state.isEditing && <button type="button" onClick={this.handleCancelEdit}>Supprimer</button>}
            <button type="button" onClick={this.handleDeleteClick}>
  Supprimer
</button>
<button type="button" onClick={this.handleDeleteClick}>
  modifier
</button>

            <button type="button" onClick={this.handleDisplayClick}>Afficher</button>
          </div>
        </form>

        {/* Liste des objectifs */}
        <ul>
          {this.state.objectifs.map(objectif => (
            <li key={objectif.id}>
              <strong>Description :</strong> {objectif.description} <br />
              <strong>Date de début :</strong> {objectif.dateDebut} <br />
              <strong>Date de fin :</strong> {objectif.dateFin} <br />
              {/* Boutons d'action */}
              <button type="button" onClick={() => this.handleEditClick(objectif.id)}>Modifier</button>
              <button type="button" onClick={() => this.handleDeleteClick(objectif.id)}>Supprimer</button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default ObjectifComponent;


