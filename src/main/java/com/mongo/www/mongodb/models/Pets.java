package com.mongo.www.mongodb.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
public class Pets {
  @Id
  public ObjectId _id;
 
  public String name;
  public String age;
 
  // Constructors
  public Pets() {}
 
  public Pets(ObjectId _id, String name, String species, String breed) {
    this._id = _id;
    this.name = name;
    this.age = species;
  }
 
  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
 
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
 
  public String getAge() { return age; }
  public void setAge(String species) { this.age = species; }

}