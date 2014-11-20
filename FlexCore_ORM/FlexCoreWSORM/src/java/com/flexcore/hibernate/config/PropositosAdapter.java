/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.hibernate.config;

/**
 *
 * @author Oscar Montes
 */
import com.flexcore.dto_hibernate.Propositos;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 *
 * @author Oscar Montes
 */
public class PropositosAdapter implements JsonSerializer<Propositos> {
  @Override
  public JsonElement serialize(Propositos proposito, Type type, JsonSerializationContext jsc) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("idcuentaPropositos", proposito.getIdcuentaPropositos());
    jsonObject.addProperty("descripcion", proposito.getDescripcion());
    return jsonObject;      
  }
}