package edu.ifba.contralador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Evento;
import edu.ifba.hibernate.entidade.Participante;

/**
 * Servlet implementation class FileUploadServer
 */
@WebServlet(name = "FileUploadServer", urlPatterns = {"/FileUploadServer"})
public class FileUploadServer extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServer() {
        super();
        // TODO Auto-generated constructor stub

    }

    /**
     * @param req
     * @param res
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub

        BeanEvento bean = new BeanEvento();
        BeanParticipante bean_Participante = new BeanParticipante();
        DiskFileItemFactory disk = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(disk);

        if (!ServletFileUpload.isMultipartContent(req)) {

        }
        try {
            List<?> itens = upload.parseRequest(req);
            // pega nome da classe para inserir image
            FileItem entidade = (FileItem) itens.get(0);
            String classe = entidade.getString();
            // capetura o codigo do objeto
            FileItem codigo = (FileItem) itens.get(1);
            int id = Integer.parseInt(codigo.getString());
            //Converte arquivo que será a image
            FileItem file = (FileItem) itens.get(2);
            byte[] bytes = read(file);
            String msg = "";
            if (classe.equals("evento")) {

               
                Evento e = bean.getEvento(id);
                e.setLogoMarca(bytes);

                if (bean.atualizar()) {
                    msg = "Imagem inserida com sucesso";
                } else {
                    msg = "Falha em tentar inserir a imagem";
                }
            }else if (classe.equals("participante")){
                Participante p = bean_Participante.getParticipante(id);
                p.setImage_Perfil(bytes);
                if (bean_Participante.atualizarParticipante()){
                       msg = "Imagem inserida com sucesso";
                }else{
                     msg = "Falha em tentar inserir a imagem";
                    
                }
                
            }

            List<Evento> lista = bean.getListaEventos();
            req.setAttribute("msg", msg);
            req.setAttribute("eventos", lista);
            req.getRequestDispatcher("adm/restritoAdministrador.jsp").forward(req, res);

        } catch (Exception e) {
            res.getOutputStream().println(e.getLocalizedMessage());
            // TODO: handle exception
        }

    }

    @SuppressWarnings("unused")
    private byte[] read(FileItem fi) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream is = fi.getInputStream();
        int read = 0;
        final byte[] b = new byte[1024];

        while ((read = is.read(b)) != -1) {
            out.write(b, 0, read);
        }
        return out.toByteArray();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        service(request, response);
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        service(request, response);
        doGet(request, response);
    }

}
