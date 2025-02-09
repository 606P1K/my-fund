PGDMP         5                {        
   courseWork    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16540 
   courseWork    DATABASE     �   CREATE DATABASE "courseWork" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Ukrainian_Ukraine.1251';
    DROP DATABASE "courseWork";
                postgres    false            �            1259    16541    contact_person    TABLE     �   CREATE TABLE public.contact_person (
    id bigint NOT NULL,
    full_name_of_contact_person character varying(255),
    phone_of_contact_person character varying(255)
);
 "   DROP TABLE public.contact_person;
       public         heap    postgres    false            �            1259    16567    contact_person_seq    SEQUENCE     |   CREATE SEQUENCE public.contact_person_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.contact_person_seq;
       public          postgres    false            �            1259    16548    military_formation    TABLE     w   CREATE TABLE public.military_formation (
    id bigint NOT NULL,
    military_formation_name character varying(255)
);
 &   DROP TABLE public.military_formation;
       public         heap    postgres    false            �            1259    16553    military_request    TABLE     �   CREATE TABLE public.military_request (
    id bigint NOT NULL,
    email character varying(255),
    path_to_file character varying(255),
    what_required character varying(255),
    military_unit_id bigint,
    person_id bigint
);
 $   DROP TABLE public.military_request;
       public         heap    postgres    false            �            1259    16568    military_request_seq    SEQUENCE     ~   CREATE SEQUENCE public.military_request_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.military_request_seq;
       public          postgres    false            �            1259    16560    military_unit    TABLE     _  CREATE TABLE public.military_unit (
    id bigint NOT NULL,
    battalion_number character varying(255),
    company character varying(255),
    current_location character varying(255),
    full_name_of_commander character varying(255),
    military_unit_number character varying(255),
    unit_name character varying(255),
    formation_id bigint
);
 !   DROP TABLE public.military_unit;
       public         heap    postgres    false            �            1259    16569    military_unit_seq    SEQUENCE     {   CREATE SEQUENCE public.military_unit_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.military_unit_seq;
       public          postgres    false                      0    16541    contact_person 
   TABLE DATA           b   COPY public.contact_person (id, full_name_of_contact_person, phone_of_contact_person) FROM stdin;
    public          postgres    false    214   0                 0    16548    military_formation 
   TABLE DATA           I   COPY public.military_formation (id, military_formation_name) FROM stdin;
    public          postgres    false    215   M                 0    16553    military_request 
   TABLE DATA           o   COPY public.military_request (id, email, path_to_file, what_required, military_unit_id, person_id) FROM stdin;
    public          postgres    false    216   �                 0    16560    military_unit 
   TABLE DATA           �   COPY public.military_unit (id, battalion_number, company, current_location, full_name_of_commander, military_unit_number, unit_name, formation_id) FROM stdin;
    public          postgres    false    217   �                  0    0    contact_person_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.contact_person_seq', 1, false);
          public          postgres    false    218                       0    0    military_request_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.military_request_seq', 1, false);
          public          postgres    false    219                       0    0    military_unit_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.military_unit_seq', 1, false);
          public          postgres    false    220            t           2606    16547 "   contact_person contact_person_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.contact_person
    ADD CONSTRAINT contact_person_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.contact_person DROP CONSTRAINT contact_person_pkey;
       public            postgres    false    214            v           2606    16552 *   military_formation military_formation_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.military_formation
    ADD CONSTRAINT military_formation_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.military_formation DROP CONSTRAINT military_formation_pkey;
       public            postgres    false    215            x           2606    16559 &   military_request military_request_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.military_request
    ADD CONSTRAINT military_request_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.military_request DROP CONSTRAINT military_request_pkey;
       public            postgres    false    216            z           2606    16566     military_unit military_unit_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.military_unit
    ADD CONSTRAINT military_unit_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.military_unit DROP CONSTRAINT military_unit_pkey;
       public            postgres    false    217            {           2606    16570 ,   military_request fkan0oa7an7nmq9eguftps8shqh    FK CONSTRAINT     �   ALTER TABLE ONLY public.military_request
    ADD CONSTRAINT fkan0oa7an7nmq9eguftps8shqh FOREIGN KEY (military_unit_id) REFERENCES public.military_unit(id);
 V   ALTER TABLE ONLY public.military_request DROP CONSTRAINT fkan0oa7an7nmq9eguftps8shqh;
       public          postgres    false    217    3194    216            |           2606    16575 ,   military_request fkeipfk17x05pyexnkqrt1p26wc    FK CONSTRAINT     �   ALTER TABLE ONLY public.military_request
    ADD CONSTRAINT fkeipfk17x05pyexnkqrt1p26wc FOREIGN KEY (person_id) REFERENCES public.contact_person(id);
 V   ALTER TABLE ONLY public.military_request DROP CONSTRAINT fkeipfk17x05pyexnkqrt1p26wc;
       public          postgres    false    216    3188    214            }           2606    16580 )   military_unit fkohk2crcge8cyl6r67lum6wntw    FK CONSTRAINT     �   ALTER TABLE ONLY public.military_unit
    ADD CONSTRAINT fkohk2crcge8cyl6r67lum6wntw FOREIGN KEY (formation_id) REFERENCES public.military_formation(id);
 S   ALTER TABLE ONLY public.military_unit DROP CONSTRAINT fkohk2crcge8cyl6r67lum6wntw;
       public          postgres    false    215    3190    217                  x������ � �         Z  x���MR�@�יS��l,�߻x�
.�rA*lx �B����~R�Ph��e���NZ�XH�(%� G��b��s�����b�|s�a�iW"jJ�QH_W�%>h#�H^�#T�!D�'�&�r�m�*U;��i���[�߸��Хǵ�,GιE���J��܅��r�����mb^���`��_k�j_m�$}�i���Ė�X�F%�o�K�r�c��on<vJ���Df	�.�XZl�^!� eɌ���h?��uk�����/o�c��o�,%s]5�syR��Ūk\�G���7��e���<U�d�����*�������u��d�����1����C            x������ � �            x������ � �     