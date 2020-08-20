/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Joyeria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("modelo.joyeria")
public class JoyeriaFacadeREST extends AbstractFacade<Joyeria> {

    @PersistenceContext(unitName = "PracticaParaExamenPU")
    private EntityManager em;

    public JoyeriaFacadeREST() {
        super(Joyeria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Joyeria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Joyeria entity) {
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
    public Joyeria find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyeria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyeria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("{Crear Joyeria")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CreaJoyeria(@FormParam("idJoyeria") Integer idJoyeria, @FormParam("Nombre") String Nombre,
            @FormParam("Ubicacion") String Ubicacion,
            @FormParam("Direccion") String Direccion, @FormParam("NombreEncargado") String NombreEncargado,
            @FormParam("DimencioLocal") Integer DimencionLocal,
            @FormParam("Ciudad") String Ciudad) {

        Joyeria joyeria = new Joyeria(idJoyeria,
                Nombre,
                Ubicacion,
                Direccion,
                NombreEncargado,
                DimencionLocal,
                Ciudad);
        super.create(joyeria);
        return "la joreia ha sido creada";
    }

    @POST
    @Path("{Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String EditarJoyeria(@FormParam("idJoyeria") Integer idJoyeria, @FormParam("Nombre") String Nombre,
            @FormParam("Ubicacion") String Ubicacion,
            @FormParam("Direccion") String Direccion, @FormParam("NombreEncargado") String NombreEncargado,
            @FormParam("DimencioLocal") Integer DimencionLocal,
            @FormParam("Ciudad") String Ciudad) {
        
       Joyeria joyeria = super.find(idJoyeria);
        joyeria.setNombre(Nombre);
        joyeria.setUbicacion(Ubicacion);
        joyeria.setDireccion(Direccion);
        joyeria.setNombreEncargado(NombreEncargado);
        joyeria.setDimencionLocal(DimencionLocal);
        joyeria.setCiudad(Ciudad);
        super.edit(joyeria);
        return "datos editados ";
    }

    @POST
    @Path("{Eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Elinimar(@FormParam("idJoyeria") Integer idJoyeria) {
      Joyeria joyeria = super.find(idJoyeria);
        super.remove(joyeria);
        return "dato eliminado";
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
