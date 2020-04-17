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

select parola,occorenze
from parolevalide
group by parola,occorenze
order by occorenze;

SELECT statistiche.maxpunteggioparola, ORDER BY maxpunteggioparola FROM statistiche
WHERE maxpunteggioparola > 3

select avg(numeroturni)
from partita
where partitaterminata = 'true';

select nomelettera,occorenza
from lettere
group by nomelettera,occorenza
order by occorenza;

select parola, idpartita, occorenze
from verificaparole
group by parola, idpartita, occorenze
order by occorenze;

______________________________________________________________________________





