package org.keegsands.sportball.model;

import jakarta.persistence.*;

@Entity
@Table(name="season")
public class Season extends AbstractNamedEntity {
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="standings_supported")
    private boolean standingsSupport;
    public boolean getStandingsSupport(){
    	return standingsSupport;
    }
    
    public void setStandingsSupport(final boolean standingsSupport){
    	this.standingsSupport = standingsSupport;
    }
    
    @Override
    public String toString(){
        return "id="+ getId()+", name="+getName();
    }
}
