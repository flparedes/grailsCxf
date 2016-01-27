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
    	// De momento el parámetro nombre no se usa para nada.
		crearProductos()
	}

	@WebMethod
    @WebResult
    def ProductoData buscarProductoPorId(String productoId) {
		ProductoData producto = null
		def productos = crearProductos()
		
		productos.each {
			if (it.getProductoId().equals(productoId)) {
				producto = it
			}
		}
		
		producto
	}
	
	/**
	 * Método auxiliar para crear una lista temporal de productos.
	 * @return Lista de productos creados.
	 */
	def List<ProductoData> crearProductos() {
		List<ProductoData> productos = new LinkedList <ProductoData>();
		
		productos.add(crearProducto('001', 'Blog', 'https://franl2p.wordpress.com'));
		productos.add(crearProducto('002', 'Autor', 'Francisco Luis Paredes'));
		productos.add(crearProducto('003', 'GitHub', 'https://github.com/flparedes'));
		
		productos
	}
	
	/**
	 * Método auxiliar para crear un producto.
	 * @param id Identificador del producto.
	 * @param nombre Nombre del producto.
	 * @param descripcion Descripción del producto.
	 * @return Producto creado.
	 */
	def ProductoData crearProducto(String id, String nombre, String descripcion) {
		ProductoData producto = new ProductoData()
		
		producto.setProductoId(id)
		producto.setNombre(nombre)
		producto.setDescripcion(descripcion)
		
		producto
	}
}
