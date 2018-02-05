/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.dataFormatar;

import edu.ifba.hibernate.entidade.Certificado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Diocesse
 */
public class FormatarData {

    public static String ddMMyyyyVisao(Date dataAtv) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dataParaBanco = format.format(dataAtv);
            return dataParaBanco;

        } catch (Exception e) {
            return null;
        }
    }

    public static String hhMMVisao(Date sqlData) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String dataParaBanco = format.format(sqlData);
            return dataParaBanco;

        } catch (Exception e) {
            return null;
        }
    }

    public static String dataCertificadoCriacao(Certificado c) {
        try {
            String pegar = c.getParticipacao().getAtividade().getEvento().getCidade() + "/" + c.getParticipacao().getAtividade().getEvento().getEstado();
            String extenso = dataPorExtenso(ddMMyyyyVisao(c.getDataCriacao()));

            return pegar + " " + extenso;
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date ddMMyyyyBancoDados(String dataAtv) {
        try {

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Date dataParaBanco = f.parse(dataAtv);
            java.sql.Date dataSql = new java.sql.Date(dataParaBanco.getTime());
            return dataSql;

        } catch (ParseException e) {
            System.err.println("Erro: " + e.getLocalizedMessage());
            return null;
        }
    }

    public static java.sql.Time horaBancoDados(String dataAtv) {
        try {

            SimpleDateFormat f = new SimpleDateFormat("HH:mm");
            Date dataParaBanco = f.parse(dataAtv);
            java.sql.Time horaSql = new java.sql.Time(dataParaBanco.getTime());
            return horaSql;

        } catch (ParseException e) {
            System.err.println("Erro: " + e.getLocalizedMessage());
            return null;
        }
    }

    public static String pegarDiaInicioDataEvento(String dataInicio, String dataFim) {
        try {
            String diaI[] = dataInicio.split("/");
            String diaF[] = dataFim.split("/");
            String subTexto = "";
            //System.out.println("Inicio: "+dia);
            if (Integer.parseInt(diaI[0]) < Integer.parseInt(diaF[0])) {
                subTexto = " no período de " + diaI[0] + " a " + diaF[0] + " " + dataExtensoMesAno(dataFim);
            }
            return subTexto;
        } catch (Exception e) {
            return null;
        }
    }

    public static String dataExtensoMesAno(String dataEvento) {
        try {
            String vectorData[] = dataEvento.split("/");
            String dataExibir = "";
            if (vectorData[1].length() == 2 && vectorData[1].equals("01")) {
                dataExibir = " de Janeiro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("02")) {
                dataExibir = " de Fevereiro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("03")) {
                dataExibir = " de Março " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("04")) {
                dataExibir = " de Abril " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("05")) {
                dataExibir = " de Maio " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("06")) {
                dataExibir = " de Junho " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("07")) {
                dataExibir = " de Julho " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("08")) {
                dataExibir = " de Agosto " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("09")) {
                dataExibir = " de Setembro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("10")) {
                dataExibir = " de Outubro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("11")) {
                dataExibir = " de Novembro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("12")) {
                dataExibir = " de Dezembro " + vectorData[2];
            } else {
                dataExibir = "Data invalida";
            }
            return dataExibir;
        } catch (Exception e) {
            return null;
        }
    }

    public static String dataPorExtenso(String dataExtenso) {
        try {
            String vectorData[] = dataExtenso.split("/");
            String dataExibir = "";
            if (vectorData[1].length() == 2 && vectorData[1].equals("01")) {
                dataExibir = vectorData[0] + " de Janeiro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("02")) {
                dataExibir = vectorData[0] + " de Fevereiro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("03")) {
                dataExibir = vectorData[0] + " de Março " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("04")) {
                dataExibir = vectorData[0] + " de Abril " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("05")) {
                dataExibir = vectorData[0] + " de Maio " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("06")) {
                dataExibir = vectorData[0] + " de Junho " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("07")) {
                dataExibir = vectorData[0] + " de Julho " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("08")) {
                dataExibir = vectorData[0] + " de Agosto " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("09")) {
                dataExibir = vectorData[0] + " de Setembro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("10")) {
                dataExibir = vectorData[0] + " de Outubro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("11")) {
                dataExibir = vectorData[0] + " de Novembro " + vectorData[2];
            } else if (vectorData[1].length() == 2 && vectorData[1].equals("12")) {
                dataExibir = vectorData[0] + " de Dezembro " + vectorData[2];
            } else {
                dataExibir = "Data invalida";
            }
            return dataExibir;
        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String args[]) {
        System.err.println(" Data: " + FormatarData.pegarDiaInicioDataEvento("12/17/2016", "15/03/2103"));
    }

}
