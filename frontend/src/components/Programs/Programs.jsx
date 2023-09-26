import React from "react";
import "./Programs.css"
import { programsData } from '../../data/programsData'


const Programs = () => {
    return (
        <div className="Programs" id="programs">
           
            <div className="programs-header" >
                <span className="stroke-text">Explore Our</span>
                <span>Programs</span>
                <span className="stroke-text">To Shape You</span>


            </div>
            <div className="programs-categories">
                {programsData.map((program)=> (
                    <div className="categorie">
                    {program.image}
                    <span>{program.heading} </span>
                    <span>{program.details}</span>
             
                    </div>
                   
                ))};
            </div>
           

        </div>
    )
}

export default Programs;