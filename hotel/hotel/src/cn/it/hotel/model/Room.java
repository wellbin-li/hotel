package cn.it.hotel.model;

import java.util.Date;



/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room  implements java.io.Serializable {


    // Fields    

     private Integer rid;
     private String rname;
     private Roomcategory roomcategory;
     private Roomstate roomstate;
     private Client client;
     private Date rdate;
     private Integer rnumber;
     private Double rcash;
     private Double rfee;
     private String rremark;
     private User user;


    @Override
	public String toString() {
		return "Room [rid=" + rid + ", rname=" + rname + ", rdate=" + rdate + ", rnumber=" + rnumber + ", rcash=" + rcash + ", rfee=" + rfee + "]";
	}

	/** default constructor */
    public Room() {
    }
   
    // Property accessors

    public Room(Integer rid, String rname, Roomcategory roomcategory,
			Roomstate roomstate,Client client,Date rdate,int rnumber,Double rcash,Double rfee, String rremark,User user) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.roomcategory = roomcategory;
		this.roomstate = roomstate;
		this.client = client;
		this.rdate=rdate;
		this.rnumber=rnumber;
		this.rcash=rcash;
		this.rfee=rfee;
		this.rremark = rremark;
		this.user=user;
	}



	public Integer getRid() {
        return this.rid;
    }
    
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return this.rname;
    }
    
    public void setRname(String rname) {
        this.rname = rname;
    }

    public Roomcategory getRoomcategory() {
		return roomcategory;
	}

	public void setRoomcategory(Roomcategory roomcategory) {
		this.roomcategory = roomcategory;
	}

	public Roomstate getRoomstate() {
		return roomstate;
	}

	public void setRoomstate(Roomstate roomstate) {
		this.roomstate = roomstate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getRremark() {
        return this.rremark;
    }
    
    public void setRremark(String rremark) {
        this.rremark = rremark;
    }

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Integer getRnumber() {
		return rnumber;
	}

	public void setRnumber(Integer rnumber) {
		this.rnumber = rnumber;
	}

	public Double getRcash() {
		return rcash;
	}

	public void setRcash(Double rcash) {
		this.rcash = rcash;
	}

	public Double getRfee() {
		return rfee;
	}

	public void setRfee(Double rfee) {
		this.rfee = rfee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    

}