package com.savu.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "APP_GROUP")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "APP_USER_GROUP", 
             joinColumns = { @JoinColumn(name = "GROUP_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
	@JsonIgnore
	private Set<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Group group = (Group) o;

		if (id != null ? !id.equals(group.id) : group.id != null)
			return false;
		if (users != null ? !users.equals(group.users) : group.users != null)
			return false;
		return !(name != null ? !name.equals(group.name) : group.name != null);

	}

	@Override
	public int hashCode() {
		int result;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (users != null ? users.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users " + users + "]";
	}
}
