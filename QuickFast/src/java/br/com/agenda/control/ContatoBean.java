/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.control;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.model.ModelContato;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Gabriel
 */
@ManagedBean(name="contatoBean")
@SessionScoped

public class ContatoBean {
    
    private ModelContato contMode = new ModelContato();
    private ContatoDao contdao = new ContatoDao();
    private List<ModelContato> lista = new ArrayList<>();

    public ContatoBean() {
        buscar();
    }

    
    
    
    public ModelContato getContMode() {
        return contMode;
    }

    public void setContMode(ModelContato contMode) {
        this.contMode = contMode;
    }

    public ContatoDao getContdao() {
        return contdao;
    }

    public void setContdao(ContatoDao contdao) {
        this.contdao = contdao;
    }

    public List<ModelContato> getLista() {
        return lista;
    }

    public void setLista(List<ModelContato> lista) {
        this.lista = lista;
    }
    
    
    
    public void salvarDados(){
        
        if(contMode.getId() == null){
            contdao.salvar(contMode);
            contMode = new ModelContato();
            buscar();
        }else{
            contdao.alterar(contMode);
            contMode = new ModelContato();
            buscar();
        }
        
    }
    
    public void buscar(){
        lista = contdao.buscar();
    }
    
    public void excluir(ModelContato c){
        contMode=c;
        contdao.deletar(contMode);
        contMode = new ModelContato();
        buscar();
        
    }
    
    public void alterar(ModelContato c){
        contMode=c;
        
    }
    
      public void procurar(ModelContato c){
        lista = contdao.encontrar(c);
        
    }
    
}
