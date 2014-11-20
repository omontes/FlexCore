/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto_hibernate.Cliente;
import com.flexcore.dto_hibernate.Clientefisico;
import com.flexcore.dto_hibernate.Clientejuridico;
import java.util.List;

/**
 *
 * @author Oscar Montes
 */
public interface TransaccionesCliente {
    Clientefisico crearClienteFisico(Clientefisico cliente) throws Exception;
    Clientejuridico crearClienteJuridico(Clientejuridico cliente) throws Exception;
    Clientefisico actualizarClienteFisico(Clientefisico cliente) throws Exception;
    Clientejuridico actualizarClienteJuridico(Clientejuridico cliente) throws Exception;
    void eliminarCliente(int idCliente) throws Exception;
    int obtenerCantidadClientesFisicosBusqueda(String entrada) throws Exception;
    int obtenerCantidadClientesJuridicosBusqueda(String entrada) throws Exception;
    List <Clientefisico> verClientesFisicosPaginadosBusqueda(int pagina, String entrada) throws Exception;
    List <Clientejuridico> verClientesJuridicosPaginadosBusqueda(int pagina, String entrada) throws Exception;
    int verificarCliente(int customerIF);
}
