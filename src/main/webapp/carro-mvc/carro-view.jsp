<!DOCTYPE html>
<%@page import="dw.CarroModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<html>
<head>
<title>Carros</title>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li class="active">Carros</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form>
              <div class="form-group">
                <input
                  required
                  name="codigo"
                  value="${param.codigo}"
                  type="number"
                  placeholder="Código"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  required
                  name="marca"
                  value="${param.marca}"
                  type="text"
                  placeholder="Marca"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  required
                  name="nome"
                  value="${param.nome}"
                  type="text"
                  placeholder="Nome"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  required
                  name="ano"
                  value="${param.ano}"
                  type="number"
                  placeholder="Ano de Fabricação"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  required
                  name="potencia"
                  value="${param.potencia}"
                  type="number"
                  placeholder="Potência (em CV)"
                  class="form-control">
              </div>
              <button name="op" value="incluir" class="btn btn-default">Incluir Novo</button>
              <button name="op" value="salvar" class="btn btn-default">Salvar Atual</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Código</td>
            <td>Marca</td>
            <td>Nome</td>
            <td>Ano de Fabricação</td>
            <td>Potência (CV)</td>
            <td>#</td>
          </tr>
          <%
          List<CarroModel> carros = (List<CarroModel>) request.getAttribute("carros");
          for (CarroModel c:carros) {
          %>
            <tr>
              <td><a href="carro?codigo=<%=c.getCodigo()%>&marca=<%=c.getMarca()%>&nome=<%=c.getNome()%>&ano=<%=c.getAno()%>&potencia=<%=c.getPotencia()%>"><%=c.getCodigo()%></a></td>
              <td><%=c.getMarca()%></td>
              <td><%=c.getNome()%></td>
              <td><%=c.getAno()%></td>
              <td><%=c.getPotencia()%></td>
              <td><a href="carro?op=excluir&codigo=<%=c.getCodigo()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>