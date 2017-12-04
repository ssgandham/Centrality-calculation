<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<body>
<h2>p2p-graph example</h2>
  <div class="torrent-graph"></div>

  <script type="text/javascript" src="./p2p-graph.min.js"></script>
  <script>
    let graph = new window.P2PGraph('.torrent-graph')
    graph.add({
      id: 'You',
      me: true,
      name: 'You'
    })
    graph.add({
      id: 'Thing1',
      me: false,
      name: '192.168.1.20'
    })
    graph.add({
      id: 'Thing2',
      me: false,
      name: '192.168.1.44'
    })
    
    graph.connect('You','Thing1')
    graph.connect('Thing1','Thing2')
    graph.connect('Thing2','Thing1')
    graph.connect('Thing2','You')
    
    /* setTimeout(() => {
      graph.connect('You', 'Thing1')
    }, 1000)
    setTimeout(() => {
      graph.rate('You', 'Thing1', 150 * 1000) // 150 KB/s
    }, 2000)
    setTimeout(() => {
      graph.rate('You', 'Thing1', 500 * 1000) // 500 KB/s
    }, 3000)
    setTimeout(() => {
      graph.rate('You', 'Thing1', 2500 * 1000) // 2.5 MB/s
    }, 4000)
    setTimeout(() => {
      graph.rate('You', 'Thing1', 5000 * 1000) // 5 MB/s
    }, 5000)
    setTimeout(() => {
      graph.rate('You', 'Thing1', 2500 * 1000) // 2.5 MB/s
    }, 6000)
    setTimeout(() => {
      graph.rate('You', 'Thing1', 1000 * 1000) // 1 MB/s
    }, 7000)
    setTimeout(() => {
      console.log('TODO: choke() - set opacity to 0.5')
      graph.choke('You', 'Thing1')
    }, 8000)
    setTimeout(() => {
      console.log('TODO: unchoke() - get back to default link opacity')
      graph.unchoke('You', 'Thing1')
    }, 9000)
    setTimeout(() => {
      graph.disconnect('You', 'Thing1')
    }, 10000)
    setTimeout(() => {
      graph.remove('Thing1')
    }, 11000)
    setTimeout(() => {
      graph.seed('Thing2', true)
    }, 12000)
    setTimeout(() => {
      graph.seed('Thing2', false)
    }, 13000) */
  </script>
</body>
</html>