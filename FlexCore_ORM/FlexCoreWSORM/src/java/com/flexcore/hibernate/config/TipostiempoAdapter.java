/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.hibernate.config;

import com.flexcore.dto_hibernate.Tipostiempo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 *
 * @author Oscar Montes
 */
public class TipostiempoAdapter implements JsonSerializer<Tipostiempo> {
  @Override
  public JsonElement serialize(Tipostiempo time, Type type, JsonSerializationContext jsc) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("idTiempo", time.getIdTiempo());
    jsonObject.addProperty("descripcion", time.getDescripcion());
    return jsonObject;      
  }
}