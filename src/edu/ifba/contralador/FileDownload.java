package edu.ifba.contralador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Evento;
import edu.ifba.hibernate.entidade.Participante;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet(name = "FileDownload", urlPatterns = "/FileDownload")
public class FileDownload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    BeanEvento bean = new BeanEvento();
    BeanParticipante beanParticipante = new BeanParticipante();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String id = request.getParameter("id");
        String entidade = request.getParameter("acao");
        int idG = Integer.parseInt(id);

        if (entidade.equals("eventoImage")) {

            Evento e = bean.getEvento(idG);
            ServletContext context = getServletConfig().getServletContext();
            String mimetype = context.getMimeType(e.getDescricao());
            response.setContentLength(e.getLogoMarca().length);
            response.setContentType(mimetype);//resp.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + e.getDescricao() + "\"");
            OutputStream out = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(e.getLogoMarca());
            byte[] buffer = new byte[e.getLogoMarca().length];
            int length;
            while ((length = in.read(buffer)) > 0) {
                try {
                    out.write(buffer, 0, length);
                } catch (IOException ex) {
                    response.getOutputStream().print(ex.getLocalizedMessage());
                }
            }
            in.close();
            out.flush();
        } else if (entidade.equals("participanteImage")) {

            Participante p = beanParticipante.getParticipante(idG);
            ServletContext context = getServletConfig().getServletContext();
            String mimetype = context.getMimeType(p.getNome());
            response.setContentLength(p.getImage_Perfil().length);
            response.setContentType(mimetype);//resp.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + p.getNome() + "\"");
            OutputStream out = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(p.getImage_Perfil());
            byte[] buffer = new byte[p.getImage_Perfil().length];
            int length;
            while ((length = in.read(buffer)) > 0) {
                try {
                    out.write(buffer, 0, length);
                } catch (IOException ex) {
                    response.getOutputStream().print(ex.getLocalizedMessage());
                }
            }
            in.close();
            out.flush();

        }

    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        service(request, response);
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        service(request, response);
        doGet(request, response);
    }

}
