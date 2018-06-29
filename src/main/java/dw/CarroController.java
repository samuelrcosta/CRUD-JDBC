package dw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/carro-mvc/carro")
public class CarroController extends HttpServlet {

	@Override
  	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String op = request.getParameter("op");
	    op = (op == null ? "" : op);
	    
	    CarroModel carro = new CarroModel();
	    	String codString = request.getParameter("codigo");
	    	if(codString != null) {
	    		carro.setCodigo(Integer.parseInt(codString));
	    	}
	 	    carro.setMarca(request.getParameter("marca"));
	 	    carro.setNome(request.getParameter("nome"));
	 	    String anoString = request.getParameter("ano");
	 	    if(anoString != null) {
	 	    	carro.setAno(Integer.parseInt(anoString));
	 	    }
	 	    String potenciaString = request.getParameter("potencia");
	 	    if(potenciaString != null) {
	 	    	carro.setPotencia(Integer.parseInt(potenciaString));
	 	    }
	   
		
	    List<CarroModel> carros = null;
	    try {
	    	
	    	if (op.equals("incluir")) {
	    		carro.incluir();
	    	}else if(op.equals("salvar")) {
	    		carro.salvar();
	    	}else if(op.equals("excluir")) {
	    		carro.excluir();
	    	}

	    	carros = CarroModel.listar();
	    	
	    } catch (SQLException e) {
	    	throw new RuntimeException(e);
	    }
	    
    
	    //Adiciona a variável na requisição para o JSP trabalhar.
	    request.setAttribute("carros", carros);

	    //Redireciona requisição para o JSP.
	    request.getRequestDispatcher("/carro-mvc/carro-view.jsp").forward(request, response);
  }
}
