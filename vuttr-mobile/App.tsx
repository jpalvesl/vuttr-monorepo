import Item from 'components/Item';
import SearchBox from 'components/SearchBox';
import { StatusBar } from 'expo-status-bar';
import { Modal, SafeAreaView, ScrollView } from 'react-native';
import './global.css';
import WebView from 'react-native-webview';
import api from 'service/api';
import { useEffect, useState } from 'react';

export default function App() {
  const [text, setText] = useState('aa');
  const [lista, setLista] = useState([]);
  const [isModalOpen, setModalOpen] = useState(false);
  const [searchByTag, setSearchByTag] = useState(false);

  async function onSearch() {
    try {
      const params = text ? { tag: text } : null;

      const { data } = await api.get('', { params });
      console.log(data);
      setLista(data);
    } catch (error) {
      console.error(error);
    }
  }

  async function handleDelete(id: string) {
    try {
      await api.delete(`/${id}`);
      const novaLista = lista.filter((item) => item.id != id);

      setLista(novaLista);
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    (async (async) => {
      try {
        const { data } = await api.get('');
        setLista(data);
        console.log(lista);
      } catch (error) {
        console.error(error);
      }
    })();
  }, []);

  return (
    <>
      <StatusBar style="light" />
      <SafeAreaView className="flex-1 bg-gray-800 pl-4 pr-4 pt-10">
        <SearchBox text={text} setText={setText} onSearch={onSearch} />

        <ScrollView showsVerticalScrollIndicator={false} className="mb-2">
          {lista.map((item) => (
            <Item key={item.id} item={item} handleDelete={() => handleDelete(item.id)} />
          ))}
        </ScrollView>
        <Modal visible={isModalOpen} onRequestClose={(state) => setModalOpen(!state)}>
          <WebView style={{ flex: 1 }} source={{ uri: 'https://expo.dev' }} />
        </Modal>
      </SafeAreaView>
    </>
  );
}
