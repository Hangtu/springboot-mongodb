package com.mongo.www.mongodb.controllers;
import com.mongo.www.mongodb.repositories.PetsRepository;
import com.mongo.www.mongodb.models.Pets;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/pets")
public class PetsController {
  @Autowired
  private PetsRepository repository;

  @GetMapping("/hi")
  public String hello(){
    return "Hello World Hang Tu";
  }
 
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Pets> getAllPets() {
    return repository.findAll();
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Pets getPetById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
 
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
    pets.set_id(id);
    repository.save(pets);
  }
 
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Pets createPet(@Valid @RequestBody Pets pets) {
    pets.set_id(ObjectId.get());
    repository.save(pets);
    return pets;
  }
 
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }

  @ExceptionHandler(Exception.class)
  public String exception(Exception e) {
      System.out.println("controller advice: exception Handler");
      System.out.println(e.getMessage());
      return e.getMessage();
  }

}