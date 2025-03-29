#!/usr/bin/env python
# -*- coding: utf-8 -*-

#Ricardo Meireles e Lucas Vinício


import string

#1
def traduzir(s):
	r = []
	palavra = ""
	letras = list(string.ascii_lowercase)
	s=s.split(",")
	for elem in s:
		if elem == "0":
			r.append(" ")
		else:
			letra = letras[int(elem)-1]
			r.append(letra)
	for i in r:
		palavra += i
	return print(palavra)

#2
def recnumero(num):
	num = str(num)
	if len(num) == 1:
		print (num[0])
		return num[0]
	print(num[0]+recnumero(num[1:]))
	return num

#3
def bytomega(b):
	kb = b/1024
	mb = kb/1024
	return round(mb,2)

def percent(total,num):
	per = (num/total)*100
	return round(per,2)

def gerarelatorio(arq):
	a = open(arq,"r")
	r =  open("relatorio.txt","w")
	l = a.readlines()
	lin = []
	totalspace = 0
	for i in l:
		lin.append(i.split())
	for n in lin:
		b = float(n[1])
		mb = bytomega(b)
		totalspace += mb
	r.write("ACME Inc. Uso do espaço em disco pelos usuários\n")
	r.write("------------------------------------------------------------------------\n")
	r.write("Nr. Usuário Espaço utilizado (MB) % do uso\n\n")
	for j in range(len(lin)):
		r.write(str(j+1))
		for dot in range(5-len(str(j+1))):
			r.write(" ")
		u = lin[j][0]
		r.write(u)
		for space in range(15-len(u)):
			r.write(" ")
		b = float(lin[j][1])
		mb = str(bytomega(b))
		r.write(mb)
		for space in range(25-len(mb)):
			r.write(" ")
		per = str(percent(totalspace,float(mb)))
		for space in range(8-len(per)):
			r.write(" ")
		r.write(per)
		r.write("%\n")
	r.write("\n")
	r.write("Espaço total ocupado:")
	r.write(str(round(totalspace,2)))
	r.write("%\n")
	r.write("Espaço médio ocupado:")
	r.write(str(round(totalspace/len(lin),2)))
	r.write("%\n")
	r.close()
	a.close()
	return

#4
def separanomearq(nomearq):
	barra = "/"
	bi = False
	for b in nomearq:
		if b == "\\":
			bi = True
	if bi == True:
		nomes = nomearq.split("\\")
	else:
		nomes = nomearq.split("/")
	cam = ""
	for i in range(1,len(nomes)-1):
		cam = cam+barra+nomes[i]
	arquivo = nomes[len(nomes)-1]
	print(cam,arquivo)
	return cam,arquivo

#5
def histograma(palavra):
	dict = {}
	for i in palavra:
		if i in dict:
			dict[i] += 1
		else:
			dict[i] = 1
	return print(dict)

#6
def lerpalavras(arq):
	a = open(arq,"r")
	linhas = a.readlines()
	lin = []
	for i in linhas:
		lin.append(i.split())
	dict = {}
	for i in range(len(lin)):
		for j in range(len(lin[i])):
			tupla = i,j
			if lin[i][j] in dict:
				dict[lin[i][j]].append(tupla)
			else:
				dict[lin[i][j]] = []
				dict[lin[i][j]].append(tupla)
	print(dict)
	return dict

#7
def existepalaavra(dict_palavras,palavra):
	if palavra in dict_palavras:
		print(dict_palavras[palavra])
		return dict_palavras[palavra]
	else:
		print([])
		return []

#8
def convertematriz(matriz):
	dict = {}
	for i in range(len(matriz)):
		for j in range(len(matriz[i])):
			tupla = i,j
			if matriz[i][j] != 0:
				dict[tupla] = matriz[i][j] 
	print(dict)
	return dict

#9
def imprimematriz(matriz_conv):
	pos = list(matriz_conv.keys())
	tam = pos[-1][0]+1
	for i in range(tam):
		for j in range(5):
			print(matriz_conv.get((i,j),0),end="")
		print()
	return

#10
def ipvalido(arq):
	a = open(arq,"r")
	ips = a.readlines()
	bi = []
	valids = []
	for i in ips:
		bi.append(i.split("."))
	for j in bi:
		v = 0
		for b in j:
			if int(b)>255:
				v = 1
		if v == 1:
			valids.append("não é um ip válido.")
		else:
			valids.append("é um ip válido.")
	for x in range(len(ips)):
		print(ips[x],valids[x])
	return

def main(args):
	traduzir("2,15,13,0,4,9,1")
	recnumero(1234)
	gerarelatorio("teste.txt")
	separanomearq("\\users\daniel\documentos\gtrabalho1.py")
	histograma("bolo")
	dicio = lerpalavras("palavras.txt")
	existepalaavra(dicio,"uma")
	matriz = [[0,0,0,1,0],[0,0,0,0,0],[0,2,0,0,0],[0,0,0,0,0],[0,0,0,3,0]]
	m = convertematriz(matriz)
	imprimematriz(m)
	ipvalido("ips.txt")
	return 0

if __name__ == '__main__':
	import sys
	sys.exit(main(sys.argv))
