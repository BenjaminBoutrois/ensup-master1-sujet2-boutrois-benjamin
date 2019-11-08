package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.Annonce;
import metier.Personne;

public class ServiceImpl implements Iservice {
	
	public static List<Personne> base;
	
	public ServiceImpl()
	{
		base = new ArrayList<Personne>();
	}

	@Override
	public int creerPersonne(List<Personne> list, Personne personne) {
		list.add(personne);
		return 0;
	}

	@Override
	public Personne getPersonne(List<Personne> list, int idPersonne) {
		for(Personne personne : list)
			if(personne.getPersonneId() == idPersonne)
				return personne;
		return null;
	}

	@Override
	public void deletePersonne(List<Personne> list, int idPersonne) {
		for(Personne personne : list)
			if(personne.getPersonneId() == idPersonne)
			{
				list.remove(personne);
				return;
			}
	}

	@Override
	public void updatePersonne(List<Personne> list, Personne p, String nom, String prenom, Date dateNaissance) {
		Personne personne = list.get(list.indexOf(p));
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setDateNaissance(dateNaissance);
	}

	@Override
	public List<Personne> findAllPersonnes() {
		if(base != null)
			return base;
		return null;
	}

	@Override
	public int getPersonneId(List<Personne> list, Personne p) {
		return list.get(list.indexOf(p)).getPersonneId();
	}

	@Override
	public void affichePersonnes() {
		for(Personne personne : base)
			System.out.println(personne);
	}

	@Override
	public void afficheAnnoncesPersonne(Personne p) {
		for(Annonce annonce : p.getAnnonces())
			System.out.println(annonce);
	}

	@Override
	public int creerAnnonce(Personne personne, Annonce a) {
		List<Annonce> annonces = personne.getAnnonces();
		annonces.add(a);
		
		return 0;
	}

	@Override
	public Annonce getAnnonce(Personne personne, int idAnnonce) {
		for(Annonce annonce : personne.getAnnonces())
			if(annonce.getIdAnnonce() == idAnnonce)
				return annonce;
		return null;
	}

	@Override
	public void deleteAnnonce(Personne personne, int idAnnonce) {
		List<Annonce> annonces = personne.getAnnonces();
		for(Annonce annonce : annonces)
			if(annonce.getIdAnnonce() == idAnnonce)
			{
				annonces.remove(annonce);
				break;
			}
		personne.setAnnonces(annonces);
	}

	@Override
	public void updateAnnonce(Personne personne, Annonce a, String intitule, String detail) {
		List<Annonce> annonces = personne.getAnnonces();
		Annonce annonce = annonces.get(annonces.indexOf(a));
		annonce.setIntitule(intitule);
		annonce.setDetail(detail);
	}

	@Override
	public List<Annonce> findAllAnnonce(Personne personne) {
		return personne.getAnnonces();
	}
	
}
