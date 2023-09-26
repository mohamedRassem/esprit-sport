import React, { Component } from 'react';
import axios from 'axios';

class CategorieSportComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      categories: [],
      nom: '',
      isEditing: false,
      selectedCategoryId: null,
    };
  }

  componentDidMount() {
    this.loadCategories();
  }

  loadCategories = () => {
    axios
      .get('http://localhost:8081/exam/categorie-sport/getCategories')
      .then((response) => {
        this.setState({ categories: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des catégories :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (categoryId) => {
    const selectedCategory = this.state.categories.find((category) => category.id === categoryId);
    if (selectedCategory) {
      this.setState({
        isEditing: true,
        selectedCategoryId: categoryId,
        nom: selectedCategory.nom,
      });
    }
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedCategoryId: null,
      nom: '',
    });
  };

  handleDeleteClick = (categoryId) => {
    const categoryIdToDelete = categoryId;

    axios
      .delete(`http://localhost:8081/exam/categorie-sport/deleteCategorie/${categoryIdToDelete}`)
      .then((response) => {
        console.log('Catégorie supprimée avec succès :', response.data);
        this.loadCategories();
        this.handleCancelEdit();
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression de la catégorie :', error);
      });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const categorieData = {
      nom: this.state.nom,
    };

    if (this.state.isEditing) {
      axios
        .put(
          `http://localhost:8081/exam/categorie-sport/updateCategorie/${this.state.selectedCategoryId}`,
          categorieData
        )
        .then((response) => {
          console.log('Catégorie mise à jour avec succès :', response.data);
          this.loadCategories();
          this.handleCancelEdit();
        })
        .catch((error) => {
          console.error('Erreur lors de la mise à jour de la catégorie :', error);
        });
    } else {
      axios
        .post('http://localhost:8081/exam/categorie-sport/addCategorie', categorieData)
        .then((response) => {
          console.log('Catégorie ajoutée avec succès :', response.data);
          this.loadCategories();
          this.setState({
            nom: '',
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout de la catégorie :', error);
        });
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'orange' }}>Gestion des Catégories de Sport</h1>

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
            <button type="submit">{this.state.isEditing ? 'Modifier' : 'Ajouter'}</button>
            {this.state.isEditing && <button type="button" onClick={this.handleCancelEdit}>Annuler</button>}
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
        

        {/* Liste des catégories */}
        <ul>
          {this.state.categories.map((category) => (
            <li key={category.id}>
              <strong>Nom :</strong> {category.nom} <br />
              {/* Boutons d'action */}
              <button type="button" onClick={() => this.handleEditClick(category.id)}>Modifier</button>
              <button type="button" onClick={() => this.handleDeleteClick(category.id)}>Supprimer</button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default CategorieSportComponent;

