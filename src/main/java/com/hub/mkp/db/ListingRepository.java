/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hub.mkp.db;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interfaccia che estende MongoRepository per fornire metodi CRUD per la classe Listing
 * @author 588se
 */
public interface ListingRepository extends MongoRepository<Listing, String> {
/**
 * Nell'architettura di Spring, le interfacce dei repository vengono utilizzate per separare la definizione delle operazioni sui dati dall'implementazione effettiva. L'interfaccia ListingRepository estende MongoRepository, che a sua volta estende altre interfacce di Spring Data come PagingAndSortingRepository e CrudRepository.
 * Estendendo MongoRepository, la tua interfaccia ListingRepository eredita automaticamente un'ampia gamma di metodi CRUD e altre funzionalità utili per lavorare con MongoDB. Spring Data si occupa dell'implementazione di questi metodi per te, il che significa che non devi preoccuparti di scrivere il codice per eseguire operazioni comuni come inserire, aggiornare, eliminare o recuperare documenti dal database.
 * Usare un'interfaccia per il repository ha diversi vantaggi:
    * Separazione dei concetti: L'interfaccia del repository definisce le operazioni sui dati che l'applicazione può eseguire, separandole dall'implementazione effettiva. Questo rende il codice più pulito, modulare e facile da mantenere.
    * Facilità di test: Poiché l'interfaccia del repository è separata dall'implementazione, è più facile testare i componenti del tuo sistema che dipendono dal repository. Puoi creare implementazioni mock dell'interfaccia del repository per testare i tuoi servizi o controller senza dover interagire con il database.
    * Flessibilità: Utilizzando un'interfaccia per il tuo repository, puoi cambiare facilmente l'implementazione sottostante senza dover modificare il codice che utilizza il repository. Ad esempio, se decidi di passare da MongoDB a un altro database, puoi sostituire l'implementazione del tuo repository senza dover modificare il codice del controller o del servizio che dipende dal repository.
* In sintesi, l'utilizzo di un'interfaccia per il repository in Spring Data è una pratica comune e consigliata che offre diversi vantaggi in termini di modularità, facilità di test e flessibilità.
    */
}
