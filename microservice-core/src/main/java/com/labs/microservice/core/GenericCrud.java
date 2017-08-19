package com.labs.microservice.core;

import java.io.Serializable;
import java.util.Collection;

public class GenericCrud<K extends Serializable, T extends Serializable> {
    /**
     * Save a new Entity object into repository, the repository could by a memory
     * data manager, nosql or traditional rdbms.
     * @param k Object to save into repository
     * @return If the object could by saved the method return object with id.
     */
    K save (K k){
        return k;
    }

    /**
     * Delete the object indicate in the param
     * @param t Object's id will by deleted, this will be checked if exists.
     * @return Return <b>TRUE</b> if the data were be deleted.
     *                <b>FALSE</b> if the data were not be deleted.
     */
    Boolean delete(T t){
        return Boolean.FALSE;
    }

    /**
     * @see GenericCrud#delete(Serializable)
     */
    Boolean delete(Collection<T> ts){
        return Boolean.FALSE;
    }

    /**
     * Find object for primary id (or key, depende of repository type)
     * @param t Id for the object.
     * @return Return the object if this one were be targeted, if this were not targeted return an empty object (not null)
     */
    K findById(T t){
        return null;
    }

    /**
     * @see GenericCrud#findById(Serializable)
     */
    Collection<K> findById(Collection<T> ts){
        return null;
    }

    /**
     * This method return all objetct.
     * Note: this method should not be usted for large dataset.
     * @return List of object.
     */
    Collection<K> findAll(){
        return null;
    }

    /**
     * Find object into repository using the same type of object for search schema.
     * @param k Condition for searching objects.
     * @return List of object or empty collection.
     */
    Collection<K> findByCondition(K k){
        return null;
    }

    /**
     * Find only one object, if the condition return more than one, this method just take the first element.
     * @param k Condition for searching objects.
     * @return Return the object or empty.
     */
    K findOne(K k){
        return null;
    }
}
