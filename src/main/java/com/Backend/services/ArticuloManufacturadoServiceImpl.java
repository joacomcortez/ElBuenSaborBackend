package com.Backend.services;

import com.Backend.entities.ArticuloManufacturado;
import com.Backend.entities.TipoArticulo;
import com.Backend.enums.EstadoBasico;
import com.Backend.repositories.ArticuloInsumoRepository;
import com.Backend.repositories.ArticuloManufacturadoRepository;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.TipoArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    TipoArticuloRepository tipoArticuloRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

//    @Override
//    public List<ArticuloManufacturado> search(String string) throws Exception {
//        try{
//            List<ArticuloManufacturado> articulosEncontrados = new ArrayList<>();
//            List<ArticuloManufacturado> articulosCandidatos = new ArrayList<>();
//            articulosCandidatos = articuloManufacturadoRepository.findAll();
//            for (int i = 0; i < articulosCandidatos.size() ; i++) {
//                if (articulosCandidatos.get(i).getDenominacion() == string){
//                    articulos.add(articulosCandidatos.get(i));
//                }
//            }
//            return null;
//        }catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//
//    }

    @Override
    public List<ArticuloManufacturado> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<ArticuloManufacturado> search(String string, Pageable pageable) throws Exception {
        return null;
    }



    @Override
    public List<ArticuloManufacturado> searchByTipo(String filtro) throws Exception {
        try{
            TipoArticulo tipoArticulo = tipoArticuloRepository.searchTipo(filtro);
            List<ArticuloManufacturado> articulos = new ArrayList<>();
            List<ArticuloManufacturado> articulosCandidatos = new ArrayList<>();
            articulosCandidatos = articuloManufacturadoRepository.findAll();
            for (int i = 0; i < articulosCandidatos.size() ; i++) {
                if (articulosCandidatos.get(i).getTipoArticulo() == tipoArticulo){
                    articulos.add(articulosCandidatos.get(i));
                }
            }
            return articulos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArticuloManufacturado cambiarEstado(Long artId, EstadoBasico estado) throws Exception{
        try{
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.getById(artId);
            articuloManufacturado.setEstado(estado);
            articuloManufacturadoRepository.save(articuloManufacturado);
            return articuloManufacturado;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



}
