import React from 'react'
import './contact.css'
import NavBar from '../NavBar/navbar';

const contact = () => {
  return (
    <div className="ma-classe">
      
      <NavBar/>
    <div
    
    className="w3-container w3-light-grey"
    style={{ padding: "128px 16px" }}
    id="contact"
  >
    <h1 className="w3-center" style={{textAlign: 'center', color: '#FF69B4'}}>Contactez Nous</h1>
    <p className="w3-center w3-large" style={{textAlign: 'center',color: '#000080', fontSize: '2em', fontWeight: 'bold'}}>Décrivez-nous votre projet à l’aide du formulaire ci-dessous. Notre équipe vous recontactera sous 24h pour vous faire une proposition d’accompagnement !</p>
    <div style={{ marginTop: 48 }}>
      
      <p>
        <i className="fa fa-phone fa-fw w3-xxlarge w3-margin-right" /> Télèphone:
        +00 151515
      </p>
      <p>
        <i className="fa fa-envelope fa-fw w3-xxlarge w3-margin-right"> </i>{" "}
        Email: quete.technologie@gmail.com
      </p>
      <br />
      <form action="/action_page.php" target="_blank">
        <p>
          <input
            className="w3-input w3-border"
            type="text"
            placeholder="Name"
            required=""
            name="Name"
          />
        </p>
        <p>
          <input
            className="w3-input w3-border"
            type="text"
            placeholder="Email"
            required=""
            name="Email"
          />
        </p>
        <p>
          <input
            className="w3-input w3-border"
            type="text"
            placeholder="Subject"
            required=""
            name="Subject"
          />
        </p>
        <p>
          <input
            className="w3-input w3-border"
            type="text"
            placeholder="Message"
            required=""
            name="Message"
          />
        </p>
        <p>
          <button className="w3-button w3-black" type="submit">
            <i className="fa fa-paper-plane" /> ENVOYER
          </button>
        </p>
      </form>
      
      <img
        src="https://flexiapps.net/wp-content/uploads/2021/07/koo-min.png" alt="Description de mon image"
        className="w3-image w3-greyscale"
        style={{ width: "100%", marginTop: 48 }}
      />
    </div>
  </div>
    
  <footer style={{ backgroundColor: '#FFE4E1', padding: '20px', textAlign: 'center' }}>
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOelUNrxkHRJiFCw2A1OpVDTi0bg_YTlo53w&usqp=CAU" alt="Logo" style={{ maxWidth: '50%', marginBottom: '10px' }} />
      <p style={{  fontSize: '1em',color: '#000080' }}>Powered by Hammami Soumaya</p>
    </footer>
 

    </div>
  )
}

export default contact