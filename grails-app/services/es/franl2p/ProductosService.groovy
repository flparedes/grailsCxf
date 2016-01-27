package es.franl2p

import javax.jws.WebMethod;
import javax.jws.WebResult;

import org.grails.cxf.utils.GrailsCxfEndpoint;

import grails.transaction.Transactional
import es.franl2p.ProductosServices
import es.franl2p.ProductoData

@Transactional
@GrailsCxfEndpoint
class ProductosService implements ProductosServices {

    @WebMethod
    @WebResult
    def List<ProductoData> buscarProductos(String nombre) {
		List<ProductoData> lista = new LinkedList<ProductoData>();
		
		lista.add(crearProducto())
		lista
	}

	@WebMethod
    @WebResult
    def ProductoData buscarProductoPorId(String productoId) {
		productoId == '001' ? crearProducto() : null;
	}
	
	/**
	 * Método auxiliar para crear un producto temporal.
	 * @return producto creado.
	 */
	def ProductoData crearProducto() {
		ProductoData producto = new ProductoData()
		
		producto.setProductoId('001')
		producto.setNombre('Blog')
		producto.setDescripcion('https://franl2p.wordpress.com')
		
		producto
	}
}
