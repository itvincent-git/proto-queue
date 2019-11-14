# -*- coding:utf-8 -*- 

import sys
import os

def saveToFile(src,fileName):
	f = open(fileName,'wb')
	try:
		for str in src:
			f.write(str)
		f.flush()
	finally:
		f.close()


def addSyntax2(src):
	if len(src)>1:
		if src[0].find('syntax') ==-1:
			 src.insert(0,'syntax = \"proto2\";\n')
		else:
			src[0] = 'syntax = \"proto2\";\n'
	return src			 

def addSyntaxVersion(src,version):
	n = -1
	for i in range(0,len(src)):
		if src[i].find('syntax') != -1:
			n = i
	if n!=-1:
		src[n] = 'syntax = \"proto'+version+'\";\n'
		return src
	src.insert(0,'syntax = \"proto'+version+'\";\n')
	return src


def addPackageName(src,packactName):
	n = -1
	for i in range(0,len(src)):
		if src[i].find('option java_package') != -1:
			n = i
	if n!=-1:
		src[n] = 'option java_package = \"'+packactName+'\";\n'
		return src
	topLine = -1
	for i in range(0,len(src)):
		if src[i].find('enum') != -1 or src[i].find('message') != -1:
			topLine = i
			break
	src.insert(topLine,'option java_package = \"'+packactName+'\";\n')
	return src

def delJavaMult(src):
	n = -1
	for i in range(0,len(src)):
		if src[i].find('option java_multiple_files') != -1:
			n = i
	if n!=-1:
		del src[n]
	return src

def addLitRunning(src):
	for i in range(0,len(src)):
		if src[i].find('option optimize_for') != -1:
			return src
	topLine = -1
	for i in range(0,len(src)):
		if src[i].find('enum') != -1 or src[i].find('message') != -1:
			topLine = i
			break
	src.insert(topLine,'option optimize_for = LITE_RUNTIME;\n')
	return src

def readFile(fileName):
	print 'deal with ->' + fileName
	f = open(fileName,"r")
	text_list = []
	try:
		all_text = f.readlines()
		for line in all_text:
			text_list.append(line)
	finally:
		f.close()
	return text_list

if __name__ == '__main__':
	if len(sys.argv) < 4 :
		print('packageName xxx.proto')
		exit() 
	packageName = sys.argv[1]
	version = sys.argv[2]
	print('packageName '+packageName)
	for (root, dirs, files) in os.walk(sys.argv[3]):
		for filename in files:
			if filename.endswith('.proto'):
				fullname=root + filename
				if fullname.endswith('empty.proto'):
				    continue
				lines = readFile(fullname)
				lines0 = delJavaMult(lines)
				lines1 = addSyntaxVersion(lines0,version)
				lines2 = addPackageName(lines1,packageName)
				lines3 = addLitRunning(lines2)
				saveToFile(lines3,fullname)

