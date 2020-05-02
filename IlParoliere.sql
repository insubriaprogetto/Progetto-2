PGDMP         -                x           IlParoliere    12.1    12.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                        0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            !           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            "           1262    16709    IlParoliere    DATABASE     �   CREATE DATABASE "IlParoliere" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';
    DROP DATABASE "IlParoliere";
                postgres    false            �            1259    16710    lettere    TABLE     u   CREATE TABLE public.lettere (
    nomelettera character varying(1) NOT NULL,
    occorenza numeric(20,0) NOT NULL
);
    DROP TABLE public.lettere;
       public         heap    postgres    false            �            1259    16794    parole    TABLE     �   CREATE TABLE public.parole (
    parola character varying(20) NOT NULL,
    idpartita numeric(5,0) NOT NULL,
    idutente numeric(5,0) NOT NULL,
    incrementopunteggio numeric(2,0) NOT NULL,
    verifica boolean NOT NULL
);
    DROP TABLE public.parole;
       public         heap    postgres    false            �            1259    16772    partita    TABLE       CREATE TABLE public.partita (
    idpartita numeric(5,0) NOT NULL,
    nomepartita character varying(10) NOT NULL,
    idutente numeric(5,0) NOT NULL,
    punteggiogiocatore numeric(3,0),
    idcreatore numeric(5,0) NOT NULL,
    partitainiziata boolean NOT NULL,
    partitaterminata boolean NOT NULL,
    numerogiocatori numeric(1,0) NOT NULL,
    numeroturni numeric(3,0),
    datacreazione date NOT NULL,
    oracreazione time without time zone NOT NULL,
    vincitore boolean NOT NULL,
    punteggiopartita numeric(2,0)
);
    DROP TABLE public.partita;
       public         heap    postgres    false            �            1259    16804    statistiche    TABLE     �  CREATE TABLE public.statistiche (
    idutente numeric(5,0) NOT NULL,
    partitevinte numeric(5,0),
    partitegiocate numeric(5,0),
    puntimassimisessione numeric(2,0),
    puntimassimipartita numeric(2,0),
    totaleturni numeric(5,0),
    punteggiperturno numeric(2,0),
    punteggipartita numeric(2,0),
    paroleduplicate numeric(5,0),
    parolenoindizionario numeric(5,0),
    parolevalide numeric(5,0),
    maxpunteggioparola numeric(2,0)
);
    DROP TABLE public.statistiche;
       public         heap    postgres    false            �            1259    16755    utente    TABLE     4  CREATE TABLE public.utente (
    id numeric(5,0) NOT NULL,
    mail character varying(100) NOT NULL,
    nome character varying(15) NOT NULL,
    cognome character varying(15) NOT NULL,
    password character varying(50) NOT NULL,
    nickname character varying(10) NOT NULL,
    isadmin boolean NOT NULL
);
    DROP TABLE public.utente;
       public         heap    postgres    false                      0    16710    lettere 
   TABLE DATA           9   COPY public.lettere (nomelettera, occorenza) FROM stdin;
    public          postgres    false    202   �                 0    16794    parole 
   TABLE DATA           \   COPY public.parole (parola, idpartita, idutente, incrementopunteggio, verifica) FROM stdin;
    public          postgres    false    205   �                 0    16772    partita 
   TABLE DATA           �   COPY public.partita (idpartita, nomepartita, idutente, punteggiogiocatore, idcreatore, partitainiziata, partitaterminata, numerogiocatori, numeroturni, datacreazione, oracreazione, vincitore, punteggiopartita) FROM stdin;
    public          postgres    false    204   �                 0    16804    statistiche 
   TABLE DATA           �   COPY public.statistiche (idutente, partitevinte, partitegiocate, puntimassimisessione, puntimassimipartita, totaleturni, punteggiperturno, punteggipartita, paroleduplicate, parolenoindizionario, parolevalide, maxpunteggioparola) FROM stdin;
    public          postgres    false    206                    0    16755    utente 
   TABLE DATA           V   COPY public.utente (id, mail, nome, cognome, password, nickname, isadmin) FROM stdin;
    public          postgres    false    203   5       �
           2606    16726    lettere lettere_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.lettere
    ADD CONSTRAINT lettere_pkey PRIMARY KEY (nomelettera);
 >   ALTER TABLE ONLY public.lettere DROP CONSTRAINT lettere_pkey;
       public            postgres    false    202            �
           2606    16798    parole parole_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.parole
    ADD CONSTRAINT parole_pkey PRIMARY KEY (parola, idpartita, idutente);
 <   ALTER TABLE ONLY public.parole DROP CONSTRAINT parole_pkey;
       public            postgres    false    205    205    205            �
           2606    16778    partita partita_idutente_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.partita
    ADD CONSTRAINT partita_idutente_key UNIQUE (idutente);
 F   ALTER TABLE ONLY public.partita DROP CONSTRAINT partita_idutente_key;
       public            postgres    false    204            �
           2606    16776    partita partita_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.partita
    ADD CONSTRAINT partita_pkey PRIMARY KEY (idpartita, idutente);
 >   ALTER TABLE ONLY public.partita DROP CONSTRAINT partita_pkey;
       public            postgres    false    204    204            �
           2606    16759    utente utente_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_pkey;
       public            postgres    false    203            �
           2606    16799 %   parole parole_idpartita_idutente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.parole
    ADD CONSTRAINT parole_idpartita_idutente_fkey FOREIGN KEY (idpartita, idutente) REFERENCES public.partita(idpartita, idutente) ON UPDATE CASCADE ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.parole DROP CONSTRAINT parole_idpartita_idutente_fkey;
       public          postgres    false    204    205    204    2708    205            �
           2606    16779    partita partita_idutente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partita
    ADD CONSTRAINT partita_idutente_fkey FOREIGN KEY (idutente) REFERENCES public.utente(id) ON UPDATE CASCADE ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.partita DROP CONSTRAINT partita_idutente_fkey;
       public          postgres    false    2704    204    203            �
           2606    16807 %   statistiche statistiche_idutente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.statistiche
    ADD CONSTRAINT statistiche_idutente_fkey FOREIGN KEY (idutente) REFERENCES public.utente(id) ON UPDATE CASCADE ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.statistiche DROP CONSTRAINT statistiche_idutente_fkey;
       public          postgres    false    2704    203    206                  x������ � �            x������ � �            x������ � �            x������ � �            x������ � �     