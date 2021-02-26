package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.alunoModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.alunoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class alunoController {

    private alunoModel alunoModel;
    private alunoRepository alunoRepository;
    private areaRepository areaRepository;
    private List<alunoModel> listaDeAluno;

    public alunoController() {
        this.alunoModel = new alunoModel();
        this.areaRepository = new areaRepository();
        this.alunoRepository = new alunoRepository();
        this.listaDeAluno = new ArrayList<>();
    }

    public alunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(alunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public alunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(alunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<alunoModel> getListaDeAluno() {
        return listaDeAluno;
    }

    public void setListaDeAluno(List<alunoModel> listaDeAluno) {
        this.listaDeAluno = listaDeAluno;
    }

    public void salvar() {
        this.alunoRepository.salvar(this.alunoModel);
    }

    public String salvarEdicao() {
        this.alunoRepository.salvar(this.alunoModel);
        return "buscarAluno.xhtml?faces-redirect=true";
    }

    public void remover(long idAluno) {
        this.alunoRepository.remover(idAluno);
    }

    public String editar(long idAluno) {
        return "editarAluno.xhtml?faces-redirect=true&idAluno=" + idAluno;
    }

    public void buscarAluno() {
        this.alunoModel = this.alunoRepository.buscarPorId(this.alunoModel.getIdPessoa());
    }

    public List<SelectItem> getAreas() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<areaModel> listaDeAreas = this.areaRepository.buscar();
        for (areaModel area : listaDeAreas) {
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        }
        return itens;
    }

    public void buscarTodosAlunos() {
        this.listaDeAluno = this.alunoRepository.buscarTodos();
    }
    
    
    
    
}
