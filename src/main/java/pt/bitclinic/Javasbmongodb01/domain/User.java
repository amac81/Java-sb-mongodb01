package pt.bitclinic.Javasbmongodb01.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document //optional (collection = "user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@MongoId
	private String myId;
	private String name;
	private String email;

	public User() {
	}

	public User(String myId, String name, String email) {
		this.myId = myId;
		this.name = name;
		this.email = email;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(myId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(myId, other.myId);
	}

	@Override
	public String toString() {
		return "User [id=" + myId + ", name=" + name + ", email=" + email + "]";
	}

}
