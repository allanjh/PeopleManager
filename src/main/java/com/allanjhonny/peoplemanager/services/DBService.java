package com.allanjhonny.peoplemanager.services;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Candidato;
import com.allanjhonny.peoplemanager.domain.Cidade;
import com.allanjhonny.peoplemanager.domain.CoordenadorLocal;
import com.allanjhonny.peoplemanager.domain.CoordenadorRegional;
import com.allanjhonny.peoplemanager.domain.Estado;
import com.allanjhonny.peoplemanager.domain.Menu;
import com.allanjhonny.peoplemanager.domain.Representante;
import com.allanjhonny.peoplemanager.domain.Usuario;
import com.allanjhonny.peoplemanager.domain.Zona;
import com.allanjhonny.peoplemanager.domain.enums.PerfilUsuario;
import com.allanjhonny.peoplemanager.repositories.CandidatoRepository;
import com.allanjhonny.peoplemanager.repositories.CidadeRepository;
import com.allanjhonny.peoplemanager.repositories.CoordLocalRepository;
import com.allanjhonny.peoplemanager.repositories.CoordRegionalRepository;
import com.allanjhonny.peoplemanager.repositories.EstadoRepository;
import com.allanjhonny.peoplemanager.repositories.MenuRepository;
import com.allanjhonny.peoplemanager.repositories.RepresentanteRepository;
import com.allanjhonny.peoplemanager.repositories.UsuarioRepository;
import com.allanjhonny.peoplemanager.repositories.ZonaRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private ZonaRepository zonaRepo;
	@Autowired
	private MenuRepository menuRepo;
	@Autowired
	private CandidatoRepository candidatoRepo;
	@Autowired
	private CoordRegionalRepository coordRegionalRepo;
	@Autowired
	private CoordLocalRepository coordLocalRepo;
	@Autowired
	private RepresentanteRepository representantelRepo;
	
	public void instantiateTestDatabase() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("people-jpa");
		EntityManager em = emf.createEntityManager();
		
		Estado estado = new Estado(null,"Pará","PA");
		
		Cidade cid1 = new Cidade(null,"Abaetetuba",estado);
		Cidade cid2 = new Cidade(null,"Mojú",estado);
		Cidade cid3 = new Cidade(null,"Oeiras do Pará",estado);
		Cidade cid4 = new Cidade(null,"Santa Maria do Pará",estado);
		
		Zona zona1 = new Zona(null,7);
		Zona zona2 = new Zona(null,37);
		Zona zona3 = new Zona(null,45);
		Zona zona4 = new Zona(null,4); 
		
		zona1.getCidades().add(cid1);
		zona2.getCidades().add(cid2);
		zona3.getCidades().add(cid3);
		zona4.getCidades().add(cid4);
		
		Menu menuCadCandidato = new Menu(null, "Candidato", "/candidatos/", PerfilUsuario.COORDENADOR);
		Menu menuCadCoordenadorRegional = new Menu(null, "Coordenador Regional", "/coordenadorRegional/", PerfilUsuario.COORDENADOR);
		Menu menuCadCoordenadorLocal = new Menu(null, "Coordenador Local", "/coordenadorLocal/", PerfilUsuario.MEMBRO);
		
		Usuario user1 = new Usuario(null, "Allan Jhonny", "Fender", PerfilUsuario.COORDENADOR);
		Usuario user2 = new Usuario(null, "Marcia", "Coelho", PerfilUsuario.MEMBRO);
		
		Candidato candidato = new Candidato(null,"Nauar",20000,0.33);
		
		CoordenadorRegional coordRegional1 = new CoordenadorRegional(null,"Josué","999999999999",candidato);
		CoordenadorRegional coordRegional2 = new CoordenadorRegional(null,"Ariovaldo","99988888888",candidato);
		
		CoordenadorLocal coordLocal1 = new CoordenadorLocal(null,"Laurimar","9999999999",coordRegional2);
		CoordenadorLocal coordLocal2 = new CoordenadorLocal(null,"Silas","94977777777",coordRegional2);
		CoordenadorLocal coordLocal3 = new CoordenadorLocal(null,"Junior","94966666666",coordRegional1);
		CoordenadorLocal coordLocal4 = new CoordenadorLocal(null,"Mainã","94955555555",coordRegional1);
		CoordenadorLocal coordLocal5 = new CoordenadorLocal(null,"André","94944444444",coordRegional2);
		
		Representante rep1 = new Representante(null,"Fernandinho","22222222",15,cid1,coordLocal1);
		Representante rep2 = new Representante(null,"Maria","22222222",10,cid1,coordLocal1);
		Representante rep3 = new Representante(null,"Isaura","22222222",13,cid1,coordLocal1);
		Representante rep4 = new Representante(null,"Taina","22222222",10,cid2,coordLocal1);
		
		Representante rep5 = new Representante(null,"Rayssa","33333333",7,cid3,coordLocal2);
		Representante rep6 = new Representante(null,"Antonio","33333333",5,cid3,coordLocal2);
		Representante rep7 = new Representante(null,"Jessica","33333333",13,cid3,coordLocal2);
		Representante rep8 = new Representante(null,"Tamires","33333333",10,cid3,coordLocal2);
		
		Representante rep9 = new Representante(null,"Joao","44444444",25,cid4,coordLocal3);
		Representante rep10 = new Representante(null,"Afonso","44444444",20,cid4,coordLocal3);
		Representante rep11 = new Representante(null,"Caio","44444444",13,cid4,coordLocal3);
		Representante rep12 = new Representante(null,"Mario","44444444",10,cid4,coordLocal3);
		
		usuarioRepo.saveAll(Arrays.asList(user1,user2));
		estadoRepo.save(estado);
		cidadeRepo.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));
		zonaRepo.saveAll(Arrays.asList(zona1, zona2, zona3, zona4));
		menuRepo.saveAll(Arrays.asList(menuCadCandidato, menuCadCoordenadorRegional, menuCadCoordenadorLocal));
		candidatoRepo.save(candidato);
		coordRegionalRepo.saveAll(Arrays.asList(coordRegional1,coordRegional2));
		coordLocalRepo.saveAll(Arrays.asList(coordLocal1,coordLocal2,coordLocal3,coordLocal4,coordLocal5));
		representantelRepo.saveAll(Arrays.asList(rep1,rep2,rep3,rep4,rep5,rep6,rep7,rep8,rep9,rep10,rep11,rep12));
		
		em.close();
		emf.close();
		
	}

}
