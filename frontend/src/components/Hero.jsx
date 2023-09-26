import React from 'react'
import './Hero.css'
import hero_image from "./../assets/hero_image.png";
import hero_image_back from "./../assets/hero_image_back.png";
import logoa from "./../assets/logoa.jpg";


/*import Heart from "./../assets/heart.png";*/
import Calories from "./../assets/calories.png";







const Hero = () => {

    return (
        <div className="hero">



            <div className="left-h">
            <img src={logoa} alt=""  />
           



            <div className="left-h">
                <span></span>
            </div>

            
           

            <ul className='header-menu'>
            
<li>Utilisateur</li>

<li>CategorieSport</li>
<li>Objectif</li>
<li>Sport</li>
<li>PlanEntrainement</li>
<li>JourEntrainement</li>
<li>Exercice</li>
<li>Entrainement</li>












</ul>
               <div className='esprit'>
                <div>
                <pre>CLUB</pre>
                <pre>                             ESPRIT</pre>
                <pre>                                                               Sport</pre>
                
                

                </div>
               </div>



               <div className="the-best-ad">
              
               <div></div>
                <span>the best fitness club in the town</span>

               </div>

<div>
               <div className='hero-text'>
                <div>
                    <span className='stroke-text'> ESPRIT SPORT</span>
                    

                </div>
                
               </div>
               

               <div>
                <span>
                IN HERE WE WILL  
                <div>HELPYOUR TO SHAPE AND BUILD YOUR</div>
                <div>HELPYOUR TO SHAPE AND BUILD YOUR IDEAL BODY AND LIVE UP YOUR LIFE TO FULLEST</div>
                </span> 
               </div>
             
               </div>

               <div className='figures'>
                <div>
                    <span>+140</span>
                    <span>expert coaches</span>
                    
                </div>
                <div>
                    <span>+216</span>
                    <span>members joined</span>
                </div>
                <div>
                    <span>+50</span>
                    <span>fitness programs</span>
                </div>
               </div>
                
                <div className='hero-buttons'>
                    <buttons className='btn'>Get Started</buttons>
                    <buttons className='btn'>Learn More</buttons>
                </div>



                </div>

               
            
            <div className="right-h">
                <button className='btn'>Join Now</button>

                </div>

                <img src={hero_image} alt="" className="hero_image" />
                <img src={hero_image_back} alt='' className='hero_image_back' />

                <div className='calories'>
                    <img src={Calories} alt='' />
                    <div>
                    <span>Calories Burned</span>
                    <span>220 kcal</span>
                    </div>
                </div>


        </div>
    )
}


export default Hero