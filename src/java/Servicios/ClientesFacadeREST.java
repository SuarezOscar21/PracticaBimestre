/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Clientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Stateless
@Path("modelo.clientes")
public class ClientesFacadeREST extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "PracticaParaExamenPU")
    private EntityManager em;

    public ClientesFacadeREST() {
        super(Clientes.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Clientes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Clientes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Clientes find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clientes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clientes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    @POST
    @Path("{Crear Cliente")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearCliente(@FormParam("idClientes")Integer idClientes,@FormParam("Nombre")String Nombre,
            @FormParam("Direccion")String Direccion,@FormParam("Correo")String Correo,
            @FormParam("Telefono")String Telefono,
            @FormParam("Ciudad")String Ciudad,@FormParam("Edad")Integer Edad,
            @FormParam("JoyeriaDePreferencia")Integer JoyeriaDePreferencia){
        
        Clientes cliente =new Clientes(idClientes,
        Nombre,
        Direccion,
        Correo,
        Telefono,
        Ciudad,
        Edad,
        JoyeriaDePreferencia);
        super.create(cliente);
        return"el cliente ha sido creado";
    }
    @POST
    @Path("{Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Editar(@FormParam("idClientes")Integer idClientes,@FormParam("Nombre")String Nombre,
            @FormParam("Direccion")String Direccion,@FormParam("Correo")String Correo,@FormParam("Telefono")String Telefono,
            @FormParam("Ciudad")String Ciudad,@FormParam("Edad")Integer Edad,
            @FormParam("JoyeriaDePreferencia")Integer JoyeriaDePreferencia){
        
        Clientes cliente=super.find(idClientes);
        cliente.setNombre(Nombre);
        cliente.setDireccion(Direccion);
        cliente.setCorreo(Correo);
        cliente.setTelefono(Telefono);
        cliente.setCiudad(Ciudad);
        cliente.setEdad(Edad);
        cliente.setJoyeriaDePreferencia(JoyeriaDePreferencia);
        
        super.edit(cliente);
        return "datos editados ";
    }
    @POST
    @Path("{Eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Elinimar(@FormParam("idClientes")Integer idClientes){
        Clientes cliente = super.find(idClientes);
        super.remove(cliente);
        return "dato eliminado";
    } 
    @POST
    @Path("PertenecenJoyeria")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Clientes>igual(@FormParam("JoyeriaDePreferencia")Integer JoyeriaDePreferencia){
        TypedQuery consulta=getEntityManager().createQuery
                ("SELECT c FROM Clientes c WHERE c.joyeriaDePreferencia = :joyeriaDePreferencia",Clientes.class);
        consulta.setParameter("JoyeriaDePreferencia",JoyeriaDePreferencia);
        return consulta.getResultList();
    }
    @POST
    @Path("MayorEdad")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Clientes>mayor(@FormParam("Edad")Integer Edad){
        TypedQuery consulta=getEntityManager().createQuery
                ("SELECT c FROM Clientes c WHERE c.edad > :edad",Clientes.class);
        consulta.setParameter("Edad",Edad);
        return consulta.getResultList();
    }
    @POST
    @Path("MismaCiudad")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Clientes>ciudad(@FormParam("Ciudad")String Ciudad){
        TypedQuery consulta=getEntityManager().createQuery
                ("SELECT c FROM Clientes c WHERE c.ciudad = :ciudad",Clientes.class);
        consulta.setParameter("Ciudad",Ciudad);
        return consulta.getResultList();
    }
    

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
