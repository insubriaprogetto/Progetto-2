
SELECT utente.id, utente.nickname , MAX(statistiche.punteggiperturno)
FROM  statistiche, utente
WHERE utente.id = statistiche.id 
GROUP BY utente.id, utente.nickname,statistiche.punteggiperturno
HAVING MAX(statistiche.punteggiperturno) = statistiche.punteggiperturno


SELECT utente.id, utente.nickname,statistiche.id FROM  statistiche, utente
WHERE utente.id = statistiche.id AND MAX(statistiche.punteggipartita);

SELECT utente.nickname, utente.id FROM utente,statistiche
WHERE utente.id = statistiche.id AND AVG

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





