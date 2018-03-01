package cn.it.hotel.model;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Business entity. @author MyEclipse Persistence Tools
 */

public class Business  implements java.io.Serializable {


    // Fields    

     private Integer bid;
     private String bname;
     private Client client;
     private Room room;
     private Roomcategory roomcategory;
     private Timestamp btime;
     private Date bdate;
     private Integer bnumber;
     private Double bcash;
     private Double bfee;
     private User user;
     private String bremark;


    @Override
	public String toString() {
		return "Business [bid=" + bid + ",bname=" + bname + ", client=" + client + ", room=" + room
				+ "roomcategory,=" + roomcategory + ", btime=" + btime + ", bdate=" + bdate + ", bnumber=" + bnumber
				+ ", bcash=" + bcash + ", bfee=" + bfee + ", user=" + user
				+ ", bremark=" + bremark + "]";
	}

	/** default constructor */
    public Business() {
    }

	/** minimal constructor */
    public Business(Timestamp btime) {
        this.btime = btime;
    }
    
    /** full constructor */
    public Business(String bname,Client client, Room room,Roomcategory roomcategory, Date bdate, Integer bnumber, Double bcash, Double bfee, String bremark,User user) {
        this.bname=bname;
        this.client=client;
        this.room = room;
        this.roomcategory=roomcategory;
        this.bdate = bdate;
        this.bnumber = bnumber;
        this.bcash = bcash;
        this.bfee = bfee;
        this.bremark = bremark;
        this.user=user;
    }

   
    // Property accessors

    public Integer getBid() {
        return this.bid;
    }
    
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Timestamp getBtime() {
        return this.btime;
    }
    
    public void setBtime(Timestamp btime) {
        this.btime = btime;
    }

    public Date getBdate() {
        return this.bdate;
    }
    
    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Integer getBnumber() {
        return this.bnumber;
    }
    
    public void setBnumber(Integer bnumber) {
        this.bnumber = bnumber;
    }

    public Double getBcash() {
        return this.bcash;
    }
    
    public void setBcash(Double bcash) {
        this.bcash = bcash;
    }

    public Double getBfee() {
        return this.bfee;
    }
    
    public void setBfee(Double bfee) {
        this.bfee = bfee;
    }

    public String getBremark() {
        return this.bremark;
    }
    
    public void setBremark(String bremark) {
        this.bremark = bremark;
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Roomcategory getRoomcategory() {
		return roomcategory;
	}

	public void setRoomcategory(Roomcategory roomcategory) {
		this.roomcategory = roomcategory;
	}


}