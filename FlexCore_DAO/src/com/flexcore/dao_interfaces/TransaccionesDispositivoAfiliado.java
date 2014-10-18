/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.DispositivoAfiliadoDTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface TransaccionesDispositivoAfiliado {
    DispositivoAfiliadoDTO crearDispositivoAfiliado(DispositivoAfiliadoDTO dispositovoAfiliado) throws Exception;
    int obtenerTarjeta(String entrada) throws Exception;
    ArrayList<DispositivoAfiliadoDTO> obtenerDispositivos() throws Exception;
    int obtenerCantidadTarjetas(int cliente) throws Exception;
}
