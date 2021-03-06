package es.franl2p;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2016-01-27T11:28:47.352+01:00
 * Generated source version: 3.1.4
 * 
 */
@WebService(targetNamespace = "http://franl2p.wordpress.com/", name = "ProductosServices")
@XmlSeeAlso({ObjectFactory.class})
public interface ProductosServices {

    @WebResult(name = "productos", targetNamespace = "")
    @RequestWrapper(localName = "buscarProductos", targetNamespace = "http://franl2p.wordpress.com/", className = "es.franl2p.BuscarProductos")
    @WebMethod
    @ResponseWrapper(localName = "buscarProductosResponse", targetNamespace = "http://franl2p.wordpress.com/", className = "es.franl2p.BuscarProductosResponse")
    public java.util.List<es.franl2p.ProductoData> buscarProductos(
        @WebParam(name = "nombre", targetNamespace = "")
        java.lang.String nombre
    );

    @WebResult(name = "producto", targetNamespace = "")
    @RequestWrapper(localName = "buscarProductoPorId", targetNamespace = "http://franl2p.wordpress.com/", className = "es.franl2p.BuscarProductoPorId")
    @WebMethod
    @ResponseWrapper(localName = "buscarProductoPorIdResponse", targetNamespace = "http://franl2p.wordpress.com/", className = "es.franl2p.BuscarProductoPorIdResponse")
    public es.franl2p.ProductoData buscarProductoPorId(
        @WebParam(name = "productoId", targetNamespace = "")
        java.lang.String productoId
    );
}
