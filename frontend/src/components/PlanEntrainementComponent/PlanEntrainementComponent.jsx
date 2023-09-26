import React, { Component } from 'react';
import axios from 'axios';

class PlanEntrainementComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      plansEntrainement: [],
      nom: '',
      description: '',
      isEditing: false,
      selectedPlanEntrainementId: null,
    };
  }

  componentDidMount() {
    this.loadPlansEntrainement();
  }

  loadPlansEntrainement = () => {
    axios
      .get('http://localhost:8081/exam/planentrainement/get-PlansEntrainement')
      .then((response) => {
        this.setState({ plansEntrainement: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des plans d\'entrainement :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (planEntrainementId) => {
    const selectedPlanEntrainement = this.state.plansEntrainement.find(
      (planEntrainement) => planEntrainement.id === planEntrainementId
    );
    if (selectedPlanEntrainement) {
      this.setState({
        isEditing: true,
        selectedPlanEntrainementId: planEntrainementId,
        nom: selectedPlanEntrainement.nom,
        description: selectedPlanEntrainement.description,
      });
    }
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedPlanEntrainementId: null,
      nom: '',
      description: '',
    });
  };

  handleDeleteClick = (planEntrainementId) => {
    axios
      .delete(`http://localhost:8081/exam/planentrainement/delete-PlanEntrainement/${planEntrainementId}`)
      .then((response) => {
        console.log('Plan d\'entrainement supprimé avec succès :', response.data);
        this.loadPlansEntrainement();
        this.handleCancelEdit();
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression du plan d\'entrainement :', error);
      });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const planEntrainementData = {
      nom: this.state.nom,
      description: this.state.description,
    };

    if (this.state.isEditing) {
      axios
        .put(
          `http://localhost:8081/exam/planentrainement/update-PlanEntrainement/${this.state.selectedPlanEntrainementId}`,
          planEntrainementData
        )
        .then((response) => {
          console.log('Plan d\'entrainement mis à jour avec succès :', response.data);
          this.loadPlansEntrainement();
          this.handleCancelEdit();
        })
        .catch((error) => {
          console.error('Erreur lors de la mise à jour du plan d\'entrainement :', error);
        });
    } else {
      axios
        .post('http://localhost:8081/exam/planentrainement/add-PlanEntrainement', planEntrainementData)
        .then((response) => {
          console.log('Plan d\'entrainement ajouté avec succès :', response.data);
          this.loadPlansEntrainement();
          this.setState({
            nom: '',
            description: '',
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout du plan d\'entrainement :', error);
        });
    }
  };

  handleDisplayClick = (planEntrainementId) => {
    const selectedPlanEntrainement = this.state.plansEntrainement.find(
      (planEntrainement) => planEntrainement.id === planEntrainementId
    );
    if (selectedPlanEntrainement) {
      console.log('Détails du plan d\'entrainement sélectionné :', selectedPlanEntrainement);
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'orange' }}>Gestion des  PlanEntrainement</h1>

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
            <textarea
              name="description"
              value={this.state.description}
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
          {this.state.plansEntrainement.map((planEntrainement) => (
            <li key={planEntrainement.id}>
              <strong>Nom :</strong> {planEntrainement.nom} <br />
              <strong>Description :</strong> {planEntrainement.description} <br />
              <button
                type="button"
                onClick={() => this.handleEditClick(planEntrainement.id)}
              >
                Modifier
              </button>
              <button
                type="button"
                onClick={() => this.handleDeleteClick(planEntrainement.id)}
              >
                Supprimer
              </button>
              <button
                type="button"
                onClick={() => this.handleDisplayClick(planEntrainement.id)}
              >
                Afficher
              </button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default PlanEntrainementComponent;




