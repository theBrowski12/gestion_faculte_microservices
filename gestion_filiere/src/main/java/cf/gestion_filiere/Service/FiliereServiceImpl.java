package cf.gestion_filiere.Service;

import cf.gestion_filiere.DTO.RequestFiliereDTO;
import cf.gestion_filiere.DTO.ResponseFiliereDTO;
import cf.gestion_filiere.Entites.Filiere;
import cf.gestion_filiere.Repository.FiliereRepository;
import cf.gestion_filiere.mappers.FiliereMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FiliereServiceImpl implements FiliereService {
    private FiliereRepository filiereRepository;
    private FiliereMapper filiereMapper;

    public FiliereServiceImpl(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    @Override
    public ResponseFiliereDTO addFiliere(RequestFiliereDTO requestFiliereDTO) {
        Filiere filiere = filiereMapper.DTO_to_Filiere(requestFiliereDTO);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.Filiere_To_DTO(savedFiliere);
    }

    @Override
    public List<ResponseFiliereDTO> getAllFilieres() {
        List<Filiere> filieres = filiereRepository.findAll();
        List<ResponseFiliereDTO> responseFiliereDTOS = new ArrayList<>();
        for (Filiere filiere : filieres) {
            responseFiliereDTOS.add(filiereMapper.Filiere_To_DTO(filiere));
        }
        return  responseFiliereDTOS;
    }

    @Override
    public ResponseFiliereDTO getFiliereById(Integer id) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow();
        return filiereMapper.Filiere_To_DTO(filiere);
    }


    @Override
    public void deleteFiliere(Integer id) {
        filiereRepository.deleteById(id);
    }

    @Override
    public ResponseFiliereDTO updateFiliere(Integer id, RequestFiliereDTO requestFiliereDTO) {
        Filiere nv_filiere = filiereMapper.DTO_to_Filiere(requestFiliereDTO);
        Filiere filiere = filiereRepository.findById(id).orElseThrow();

        if(nv_filiere.getCode() !=null) filiere.setCode(nv_filiere.getCode());
        if(nv_filiere.getLibelle() !=null) filiere.setLibelle(nv_filiere.getLibelle());

        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.Filiere_To_DTO(savedFiliere);
    }

}
