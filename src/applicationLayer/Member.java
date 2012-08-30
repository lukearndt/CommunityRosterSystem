package applicationLayer;
public class Member {
	private int ID;
	private String name;
	private String address;
	private String suburb;
	private String state;
	private String postCode;
	private int spouseID;
	private String homePhone;
	private String mobilePhone;

	public Member (int aID, String aName, String aAddress, String aSuburb, String aState, String aPostCode, int aSpouseID, String aHomePhone, String aMobilePhone) {
		ID = aID;
		name = aName;
		address = aAddress;
		suburb = aSuburb;
		state = aState;
		postCode = aPostCode;
		spouseID = aSpouseID;
		homePhone = aHomePhone;
		mobilePhone = aMobilePhone;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getSpouseID() {
		return spouseID;
	}

	public void setSpouseID(int spouseID) {
		this.spouseID = spouseID;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
}
