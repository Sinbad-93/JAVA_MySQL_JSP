package com.fullstackjee.dao;

import java.util.List;

import com.fullstackjee.beans.Utilisateur;



public interface UtilisateurDao {
	 void ajouter( Utilisateur utilisateur );
	    List<Utilisateur> lister();
}
