package org.humbold.app;
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
import java.io.Serializable;
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
public class RegistroDarwin implements Serializable
{
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	private static final long serialVersionUID = -3301302347466614158L;
	//***************************************************
	//***************************************************
	//***************************************************
	private String id;
	private String _rev;
	private String taxonID;
	private String scientificName;								//": "Especimen cientifico D Lina Garcia",
	private String scientificNameWithoutAuthorship;		//"Especimen cientifico D",
	private String scientificNameAuthorship;				//": "Lina Garcia",
	private String family;											//": " FAMILIA2",
	private String taxonRank;									//": "species",
	private String taxonomicStatus;							//": "accepted",
	private String acceptedNameUsage;						//": "Especimen cientifico D Lina Garcia",
	private String identifier;										//": "3fd9a42b-f209-424d-827c-8a4ff86f3889",
	private String type;											//": "taxon",
	private String created;										//": 1479329397,
	private String modified;										//": 1479329397,
	private String creator;										//": "Jaime Alberto Gutierrez",
	private String contributor;									//": "Jaime Alberto Gutierrez",
	private String contact;										//": "jaimealbertogutierrez@gmail.com",
	private String source;											//": "User"
	
	//***************************************************
	//***************************************************
	//***************************************************
	public RegistroDarwin() {
		// TODO Auto-generated constructor stub
	}
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public String getTaxonID() {
		return taxonID;
	}

	public void setTaxonID(String taxonID) {
		this.taxonID = taxonID;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getScientificNameWithoutAuthorship() {
		return scientificNameWithoutAuthorship;
	}

	public void setScientificNameWithoutAuthorship(
			String scientificNameWithoutAuthorship) {
		this.scientificNameWithoutAuthorship = scientificNameWithoutAuthorship;
	}

	public String getScientificNameAuthorship() {
		return scientificNameAuthorship;
	}

	public void setScientificNameAuthorship(String scientificNameAuthorship) {
		this.scientificNameAuthorship = scientificNameAuthorship;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getTaxonRank() {
		return taxonRank;
	}

	public void setTaxonRank(String taxonRank) {
		this.taxonRank = taxonRank;
	}

	public String getTaxonomicStatus() {
		return taxonomicStatus;
	}

	public void setTaxonomicStatus(String taxonomicStatus) {
		this.taxonomicStatus = taxonomicStatus;
	}

	public String getAcceptedNameUsage() {
		return acceptedNameUsage;
	}

	public void setAcceptedNameUsage(String acceptedNameUsage) {
		this.acceptedNameUsage = acceptedNameUsage;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
	//***************************************************
}
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
/***************************************************/
