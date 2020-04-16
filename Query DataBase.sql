SELECT utente.id, utente.nickname , statistiche.punteggiperturno
FROM  statistiche, utente
WHERE utente.id = statistiche.id and statistiche.punteggiperturno>= ALL(select punteggiperturno from statistiche)
GROUP BY utente.id, utente.nickname,statistiche.punteggiperturno

SELECT utente.id, utente.nickname, punteggipartita
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.punteggipartita>= ALL(select punteggipartita from statistiche)
group by utente.id, punteggipartita

SELECT utente.id,utente.nickname, partita.punteggiopartita, partita.idpartita
FROM utente,partita
WHERE utente.id = partita.id 
group by partita.punteggiopartita,partita.idpartita, utente.id,utente.nickname

SELECT utente.nickname, utente.id, count(paroledublicate) FROM utente,statistiche
WHERE utente.id = statistiche.id AND MAX(paroleduplicate);

SELECT utente.nickname, utente.id, count(paroledublicate) FROM utente,statistiche
WHERE utente.id = statistiche.id AND MAX (parolenoindizionario);

SELECT parolevalide.parola, parolevalide.count, ORDER BY parolevalide.count FROM parolevalide

SELECT statistiche.maxpunteggioparola, ORDER BY maxpunteggioparola FROM statistiche
WHERE maxpunteggioparola > 3

SELECT AVG(partita.turnidigioco, MAX numeroturni, MIN numeroturni FROM partita
WHERE partita.terminata = true 
GROUP BY AVG partita.turnidigioco)

SELECT lettere.nome, COUNT(occcorenza) FROM lettere GROUP BY occorenza

SELECT parola, idpartita, COUNT(parola) FROM verificaparole,partita
WHERE partita.idpartita = verificaparole.idpartita
GROUP BY parola 

______________________________________________________________________________





