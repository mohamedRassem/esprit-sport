import React, { Component } from 'react';
import axios from 'axios';
import "./UtilisateurComponent.css"
import image1 from '../../assets/image1.png';




class UtilisateurComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      utilisateurs: [],
      nom: '',
      prenom: '',
      email: '',
      motDePasse: '',
      age: 0,
      sexe: '',
      poids: 0,
      taille: 0,
      niveauForme: '',
      isEditing: false,
      selectedUserId: null,
    };
  }

  componentDidMount() {
    this.loadUtilisateurs();
  }

  loadUtilisateurs = () => {
    axios
      .get('http://localhost:8081/exam/utilisateur/get-Utilisateurs')
      .then((response) => {
        this.setState({ utilisateurs: response.data });
      })
      .catch((error) => {
        console.error('Erreur lors du chargement des utilisateurs :', error);
      });
  };

  handleInputChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleEditClick = (userId) => {
    const selectedUser = this.state.utilisateurs.find((user) => user.id === userId);
    if (selectedUser) {
      this.setState({
        isEditing: true,
        selectedUserId: userId,
        nom: selectedUser.nom,
        prenom: selectedUser.prenom,
        email: selectedUser.email,
        motDePasse: selectedUser.motDePasse,
        age: selectedUser.age,
        sexe: selectedUser.sexe,
        poids: selectedUser.poids,
        taille: selectedUser.taille,
        niveauForme: selectedUser.niveauForme,
      });
    }
  };

  handleCancelEdit = () => {
    this.setState({
      isEditing: false,
      selectedUserId: null,
      nom: '',
      prenom: '',
      email: '',
      motDePasse: '',
      age: 0,
      sexe: '',
      poids: 0,
      taille: 0,
      niveauForme: '',
    });
  };

  handleDeleteClick = (nomUtilisateur) => {
    axios
    .delete(`http://localhost:8081/exam/utilisateur/delete-Utilisateur/${nomUtilisateur}`)
    .then((response) => {
      console.log('Réponse de suppression :', response);
      console.log('Utilisateur supprimé avec succès :', response.data);
      this.loadUtilisateurs();
    })
    .catch((error) => {
      console.error('Erreur lors de la suppression de l\'utilisateur :', error);
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const utilisateurData = {
      nom: this.state.nom,
      prenom: this.state.prenom,
      email: this.state.email,
      motDePasse: this.state.motDePasse,
      age: this.state.age,
      sexe: this.state.sexe,
      poids: this.state.poids,
      taille: this.state.taille,
      niveauForme: this.state.niveauForme,
    };

    if (this.state.isEditing) {
      axios
      .put(
        `http://localhost:8081/exam/utilisateur/update-Utilisateur/${this.state.selectedUserName}`,
        utilisateurData
      )
      .then((response) => {
        console.log('Utilisateur mis à jour avec succès :', response.data);
        this.loadUtilisateurs();
        this.handleCancelEdit();
      })
      .catch((error) => {
        console.error('Erreur lors de la mise à jour de l\'utilisateur :', error);
      });
    } else {
      axios
        .post('http://localhost:8081/exam/utilisateur/add-Utilisateur', utilisateurData)
        .then((response) => {
          console.log('Utilisateur ajouté avec succès :', response.data);
          this.loadUtilisateurs();
          this.setState({
            nom: '',
            prenom: '',
            email: '',
            motDePasse: '',
            age: 0,
            sexe: '',
            poids: 0,
            taille: 0,
            niveauForme: '',
          });
        })
        .catch((error) => {
          console.error('Erreur lors de l\'ajout de l\'utilisateur :', error);
        });
    }
  };

  render() {
    return (
      
      <div>
        
        <h1 style={{ color: 'orange' }}>Gestion des Utilisateurs</h1>

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












            <label>Prénom :</label>
            <input
              type="text"
              name="prenom"
              value={this.state.prenom}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <label>Email :</label>
            <input
              type="email"
              name="email"
              value={this.state.email}
              onChange={this.handleInputChange}
            />
          </div>
          <div>
            <label>Mot de passe :</label>
            <input
                            type="password"
                            name="motDePasse"
                            value={this.state.motDePasse}
                            onChange={this.handleInputChange}
                          />
                        </div>
                        <div>
                          <label>Âge :</label>
                          <input
                            type="number"
                            name="age"
                            value={this.state.age}
                            onChange={this.handleInputChange}
                          />
                        </div>
                        <div>
                          <label>Sexe :</label>
                          <input
                            type="text"
                            name="sexe"
                            value={this.state.sexe}
                            onChange={this.handleInputChange}
                          />
                        </div>
                        <div>
                          <label>Poids :</label>
                          <input
                            type="number"
                            name="poids"
                            value={this.state.poids}
                            onChange={this.handleInputChange}
                          />
                        </div>
                        <div>
                          <label>Taille :</label>
                          <input
                            type="number"
                            name="taille"
                            value={this.state.taille}
                            onChange={this.handleInputChange}
                          />
                        </div>
                        <div>
                          <label>Niveau de forme :</label>
                          <input
                            type="text"
                            name="niveauForme"
                            value={this.state.niveauForme}
                            onChange={this.handleInputChange}
                          />
                        </div>
                        <div>
                          {/* Date d'inscription (affichage uniquement) */}
                          <label>Date d'inscription :</label>
                          <input
                            type="text"
                            name="dateInscription"
                            value={this.state.dateInscription}
                            readOnly // Pour le rendre en lecture seule
                          />
                        </div>
                        {/* Boutons d'action */}
                        
                        <div>
                          <button type="submit">
                            {this.state.isEditing ?  'Modifier' : 'Ajouter' }
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
                       
                        

                        <div>
                        








  </div>
                        

                      </form>

                      
                      <div className='left-r'>
                <img src={image1} alt='' />
             

            </div>




























              
                      {/* Liste des utilisateurs */}
                      <ul>
                        {this.state.utilisateurs.map((user) => (
                          <li key={user.id}>
                            <strong>Nom:</strong> {user.nom} <br />
                            <strong>Prénom:</strong> {user.prenom} <br />
                            <strong>Email:</strong> {user.email} <br />
                            <strong>Âge:</strong> {user.age} <br />
                            <strong>Sexe:</strong> {user.sexe} <br />
                            <strong>Poids:</strong> {user.poids} <br />
                            <strong>Taille:</strong> {user.taille} <br />
                            <strong>Niveau de forme:</strong> {user.niveauForme} <br />
                            <strong>Date d'inscription:</strong> {user.dateInscription} <br />
                            {/* Boutons d'action */}
                            <button type="button" onClick={() => this.handleDeleteClick(user.nom)}>Supprimer</button>

                            <button type="button" onClick={() => this.handleDeleteClick(user.id)}>
                              Supprimer
                            </button>
                          </li>
                        ))}
                      </ul>
                    </div>
                  );
                }
              }
              
              export default UtilisateurComponent;
              














    







