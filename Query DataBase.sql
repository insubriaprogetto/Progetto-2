SELECT utente.id, utente.nickname , statistiche.punteggiperturno
FROM  statistiche, utente
WHERE utente.id = statistiche.id and statistiche.punteggiperturno>= ALL(select punteggiperturno from statistiche)
GROUP BY utente.id, utente.nickname,statistiche.punteggiperturno

SELECT utente.id, utente.nickname, punteggipartita
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.punteggipartita>= ALL(select punteggipartita from statistiche)
group by utente.id, punteggipartita;

SELECT utente.id, utente.nickname, statistiche.numeroturni
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.numeroturni>= ALL(select numeroturni from statistiche)
group by utente.id,utente.nickname, statistiche.numeroturni;

SELECT utente.id,utente.nickname, partita.punteggiopartita, partita.idpartita
FROM utente,partita
WHERE utente.id = partita.id 
group by partita.punteggiopartita,partita.idpartita, utente.id,utente.nickname;

SELECT utente.id, utente.nickname, statistiche.paroleduplicate
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.paroleduplicate>= ALL(select paroleduplicate from statistiche)
group by utente.id,utente.nickname, statistiche.paroleduplicate;

SELECT utente.id, utente.nickname, statistiche.parolenoindizionario
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.parolenoindizionario>= ALL(select parolenoindizionario from statistiche)
group by utente.id,utente.nickname, statistiche.parolenoindizionario;


SELECT statistiche.maxpunteggioparola, ORDER BY maxpunteggioparola FROM statistiche
WHERE maxpunteggioparola > 3

select avg(numeroturni)
from partita
where partitaterminata = 'true';

select max(numeroturni)as massimoturni, min(numeroturni) as minimoturni
from partita
where partitaterminata = 'true';

select nomelettera,occorenza
from lettere
group by nomelettera,occorenza
order by occorenza;

select parola,count(parola) as occorrenze
from parolevalide
group by parola
order by occorrenze;

select partita.id,  avg(punteggiogiocatore)
from partita
group by partita.id	
having avg(punteggiogiocatore) >= all (select avg(punteggiogiocatore)
											from partita );



______________________________________________________________________________





