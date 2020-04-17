1)
SELECT utente.id, utente.nickname , statistiche.punteggiperturno
FROM  statistiche, utente
WHERE utente.id = statistiche.id and statistiche.punteggiperturno>= ALL(select punteggiperturno from statistiche)
GROUP BY utente.id, utente.nickname,statistiche.punteggiperturno
1)
SELECT utente.id, utente.nickname, punteggipartita
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.punteggipartita>= ALL(select punteggipartita from statistiche)
group by utente.id, punteggipartita;

2)
SELECT utente.id, utente.nickname, statistiche.numeroturni
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.numeroturni>= ALL(select numeroturni from statistiche)
group by utente.id,utente.nickname, statistiche.numeroturni;

2)
SELECT utente.id,utente.nickname, partita.punteggiopartita, partita.idpartita
FROM utente,partita
WHERE utente.id = partita.id 
group by partita.punteggiopartita,partita.idpartita, utente.id,utente.nickname;

4)
SELECT utente.id, utente.nickname, statistiche.paroleduplicate
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.paroleduplicate>= ALL(select paroleduplicate from statistiche)
group by utente.id,utente.nickname, statistiche.paroleduplicate;

5)
SELECT utente.id, utente.nickname, statistiche.parolenoindizionario
FROM statistiche, utente
WHERE utente.id = statistiche.id and statistiche.parolenoindizionario>= ALL(select parolenoindizionario from statistiche)
group by utente.id,utente.nickname, statistiche.parolenoindizionario;


8)
select avg(numeroturni)
from partita
where partitaterminata = 'true';

9)
select max(numeroturni)as massimoturni, min(numeroturni) as minimoturni
from partita
where partitaterminata = 'true';

10)
select nomelettera,occorenza
from lettere
group by nomelettera,occorenza
order by occorenza desc;

6)
select parola,count(parola) as occorrenze
from parolevalide
group by parola
order by occorrenze desc ;

3)
select partita.id,  avg(punteggiogiocatore)
from partita
group by partita.id	
having avg(punteggiogiocatore) >= all (select avg(punteggiogiocatore)
				from partita );

7)
select *
from parolevalide
where incrementopunteggio >= 4;




select parola, idpartita
from verificaparole
group by parola, idpartita




______________________________________________________________________________





