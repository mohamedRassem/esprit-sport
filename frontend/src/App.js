import './App.css';
import React from 'react';
import Hero from './components/Hero' ;
import Programs from './components/Programs/Programs' ;
import Header from './components/Header/Header' ;
import Reasons from './components/Reasons/Reasons' ;
import UtilisateurComponent from './components/UtilisateurComponent/UtilisateurComponent' ;
import ObjectifComponent from './components/ObjectifComponent/ObjectifComponent' ;
import CategorieSportComponent from './components/CategorieSportComponent/CategorieSportComponent' ;
import SportComponent from './components/SportComponent/SportComponent' ;
import ExerciceComponent from './components/ExerciceComponent/ExerciceComponent' ;
import EntrainementComponent from './components/EntrainementComponent/EntrainementComponent' ;
import PlanEntrainementComponent from './components/PlanEntrainementComponent/PlanEntrainementComponent' ;
import JourEntrainementComponent from './components/JourEntrainementComponent/JourEntrainementComponent' ;






















function App() {
  return (
    
    <div className="App">
     
 
  
     
      <Hero/>
      <Header/>
      <Programs/>  
      <Reasons/> 
      <UtilisateurComponent/>
      <ObjectifComponent/>
      <CategorieSportComponent/>
      <SportComponent/>
      <ExerciceComponent/>
      <EntrainementComponent/>
      <PlanEntrainementComponent/>
      <JourEntrainementComponent/>
      
    



      
      
      
    </div>
  );
}

export default App;
